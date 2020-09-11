package com.alykhaled.gdgproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alykhaled.gdgproject.services.LearnerService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmitActivity extends AppCompatActivity {
    TextView firstName;
    TextView lastName;
    TextView emailAddress;
    TextView projectLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        emailAddress = findViewById(R.id.emailAddress);
        projectLink = findViewById(R.id.projectLink);
        Button submitBtn = findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSureDialog();

            }
        });

    }
    private void showSureDialog() {
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View promptView = layoutInflater.inflate(R.layout.sure_layout, null);

        final AlertDialog alertD = new AlertDialog.Builder(this).create();


        Button btnAdd1 = (Button) promptView.findViewById(R.id.buttonOk);

        btnAdd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://docs.google.com/forms/d/e/";

                Retrofit retrofit = null;
                Gson gson = new GsonBuilder()
                        .setLenient()
                        .create();

                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(url)
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .build();
                }

                LearnerService service = retrofit.create(LearnerService.class);

                Call<Void> learnerCall = service.postProject(emailAddress.getText().toString(),firstName.getText().toString(),lastName.getText().toString(),projectLink.getText().toString());

                learnerCall.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        showSuccessDialog();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        showFailDialog();
                    }
                });
            }
        });


        alertD.setView(promptView);

        alertD.show();

    }

    private void showSuccessDialog() {
        ViewGroup viewGroup = findViewById(android.R.id.content);

        View dialogView = LayoutInflater.from(this).inflate(R.layout.success_layout, viewGroup, false);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setView(dialogView);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    private void showFailDialog() {
        ViewGroup viewGroup = findViewById(android.R.id.content);

        View dialogView = LayoutInflater.from(this).inflate(R.layout.fail_layout, viewGroup, false);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setView(dialogView);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}