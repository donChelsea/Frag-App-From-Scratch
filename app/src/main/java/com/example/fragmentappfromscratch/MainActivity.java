package com.example.fragmentappfromscratch;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.fragmentappfromscratch.controller.PlanetAdapter;
import com.example.fragmentappfromscratch.model.Planet;
import com.example.fragmentappfromscratch.model.PlanetList;
import com.example.fragmentappfromscratch.network.PlanetService;
import com.example.fragmentappfromscratch.network.RetrofitSingleton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main Activity";
    private RecyclerView recyclerView;
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        retrofit = new RetrofitSingleton().getInstance();
        PlanetService planetService = retrofit.create(PlanetService.class);
        final Call<PlanetList> planetListCall = planetService.getPlanetList();
        planetListCall.enqueue(new Callback<PlanetList>() {
            @Override
            public void onResponse(@NonNull Call<PlanetList> call, @NonNull Response<PlanetList> response) {
                Log.d("TAG", "onResponse: " + response.body().getPlanetList().get(0).getName());
                List<Planet> planetList = response.body().getPlanetList();
                PlanetAdapter planetAdapter = new PlanetAdapter(getApplicationContext(), planetList);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                recyclerView.setAdapter(planetAdapter);
            }

            @Override
            public void onFailure(@NonNull Call<PlanetList> call, Throwable t) {
                Log.d(TAG, "onFailure: something went wrong");
            }
        });
    }
}
