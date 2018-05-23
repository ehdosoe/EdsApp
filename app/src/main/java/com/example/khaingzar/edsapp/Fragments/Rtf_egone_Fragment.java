package com.example.khaingzar.edsapp.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.khaingzar.edsapp.Adapters.Rtf_egone_DataAdapter;
import com.example.khaingzar.edsapp.Interfaces.Rtf_egone_MoviesInterface;
import com.example.khaingzar.edsapp.Models.Rtf_egone_Movies;
import com.example.khaingzar.edsapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.facebook.FacebookSdk.getApplicationContext;

public class Rtf_egone_Fragment extends Fragment {

    private RecyclerView recyclerView;
    private Rtf_egone_DataAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_rtf_egone,container,false);
        recyclerView = (RecyclerView)v.findViewById(R.id.rtf_egone_recycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
        return v;
    }

    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        Rtf_egone_MoviesInterface request = retrofit.create(Rtf_egone_MoviesInterface.class);
        Call<List<Rtf_egone_Movies>> call = request.getJSON();
        call.enqueue(new Callback<List<Rtf_egone_Movies>>() {
            @Override
            public void onResponse(Call<List<Rtf_egone_Movies>> call, Response<List<Rtf_egone_Movies>> response) {

                List<Rtf_egone_Movies> moviesList = response.body();
                adapter = new Rtf_egone_DataAdapter((ArrayList<Rtf_egone_Movies>) moviesList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Rtf_egone_Movies>> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }
}
