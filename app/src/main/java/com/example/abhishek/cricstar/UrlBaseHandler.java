package com.example.abhishek.cricstar;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by abhishek on 04/07/17.
 */

public class UrlBaseHandler {




    public static CricketEndpoints BaseUrl(){
        String API_BASE_URL = "http://cricapi.com";

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS);

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );

        Retrofit retrofit =
                builder.client(
                                httpClient.build()
                        )
                        .build();

        return retrofit.create(CricketEndpoints.class);


    }



}
