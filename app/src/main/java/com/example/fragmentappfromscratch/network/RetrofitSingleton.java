package com.example.fragmentappfromscratch.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private String BASE_URL = "https://raw.githubusercontent.com/";
    private Retrofit instance;

    public RetrofitSingleton() {
        this.instance = instance;
    }

    public Retrofit getInstance() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
}
