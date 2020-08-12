package com.yono.androiddesignandstyle.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHelper {
    public static final String BASE_URL = "https://fakestoreapi.com/";

    public static Retrofit client(String baseUrl){
        Retrofit client = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return client;
    }
}
