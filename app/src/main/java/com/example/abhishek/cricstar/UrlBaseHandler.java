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

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS);

//        OkHttpClient httpClient = new OkHttpClient();
//        httpClient.readTimeoutMillis(60 * 1000, TimeUnit.MILLISECONDS)
//
//        Retrofit.Builder builder =
//                new Retrofit.Builder()
//                        .baseUrl(API_BASE_URL)
//                        .addConverterFactory(
//                                GsonConverterFactory.create()
//                        );
//
//        Retrofit retrofit =
//                builder.client(
//                                httpClient.build()
//                        )
//                        .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AllStrings.BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        return retrofit.create(CricketEndpoints.class);


    }



}
