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


public class SkillFragment extends Fragment {


    private LinearLayoutManager layoutManager;

    private List<SkillItem> mSkillList;
    public SkillFragment() {
        // Required empty public constructor
    }


    public static SkillFragment newInstance(String param1, String param2) {
        SkillFragment fragment = new SkillFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_skill,container,false);
        mSkillList = new ArrayList<>();
        String url = "https://gadsapi.herokuapp.com/api/";

        Retrofit retrofit = null;

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        LearnerService service = retrofit.create(LearnerService.class);

        Call<List<SkillItem>> skillCall = service.getSkills();
        skillCall.enqueue(new Callback<List<SkillItem>>() {
            @Override
            public void onResponse(Call<List<SkillItem>> call, Response<List<SkillItem>> response) {
                mSkillList = response.body();

                RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.skill_view);

                layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);

                SkillAdapter recyclerViewAdapter = new SkillAdapter(getContext(), mSkillList);
                recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<List<SkillItem>> call, Throwable t) {

            }
        });

        return view;
    }
}