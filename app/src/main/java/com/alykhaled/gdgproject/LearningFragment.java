package com.alykhaled.gdgproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alykhaled.gdgproject.services.LearnerService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LearningFragment extends Fragment {

    private LinearLayoutManager layoutManager;

    private List<LearnerItem> mLearnerList;
    public LearningFragment() {
        // Required empty public constructor
    }


    public static LearningFragment newInstance(String param1, String param2) {
        LearningFragment fragment = new LearningFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_learning,container,false);
        mLearnerList = new ArrayList<>();
        String url = "https://gadsapi.herokuapp.com/api/";

        Retrofit retrofit = null;

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        LearnerService service = retrofit.create(LearnerService.class);

        Call<List<LearnerItem>> learnerCall = service.getLearner();

        learnerCall.enqueue(new Callback<List<LearnerItem>>() {
            @Override
            public void onResponse(Call<List<LearnerItem>> call, Response<List<LearnerItem>> response) {
                mLearnerList = response.body();

                RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.learning_view);

                layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);

                LearnerAdapter recyclerViewAdapter = new LearnerAdapter(getContext(), mLearnerList);
                recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<List<LearnerItem>> call, Throwable t) {
                Log.i("autolog", t.getMessage());
            }
        });


        return view;
    }
}