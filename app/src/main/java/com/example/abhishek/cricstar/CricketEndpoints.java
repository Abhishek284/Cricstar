package com.example.abhishek.cricstar;

import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by abhishek on 04/07/17.
 */

public interface CricketEndpoints {
    @SerializedName("Content-Type")
    public String ContentType =null;

    @GET("/api/matches")
    Call<DataParse> getAllUpcomingMatches(@Header("apikey") String apikey);



    @POST("/api/fantasySquad")
    Call<PlayersListResponse> getAllPlayerList(@Header("ContentType") String ContentType, @Body MatchDetails.ReqBody reqBody);









}

