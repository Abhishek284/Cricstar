package com.example.abhishek.cricstar;

import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by abhishek on 04/07/17.
 */

public interface CricketEndpoints {
    @SerializedName("Content-Type")
    public String ContentType =null;
    @POST("/api/matches")

    Call<DataParse> getAllUpcomingMatches(@Header("apikey") String apikey);


//    @POST("/api/matches")
//    Call<DataParse> getAllUpcomingMatches(@Header("ContentType") String ContentType, @Body DashboardActivity.ReqBody reqBody);









}

