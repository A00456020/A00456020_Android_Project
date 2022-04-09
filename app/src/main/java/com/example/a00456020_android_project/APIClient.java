package com.example.a00456020_android_project;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    public static Retrofit apiInstance;
    public static String API_URL = "10.0.2.2:8080";

    public static Retrofit getApiInstance(){
        if (apiInstance == null){
            apiInstance = new Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return apiInstance;
    }
}
