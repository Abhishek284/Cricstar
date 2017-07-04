package com.example.abhishek.cricstar;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by abhishek on 04/07/17.
 */

public interface CricketEndpoints {
    @GET("/api/matches")
    Call<DataParse> getAllUpcomingMatches(@Query("apikey") String apiKey);





}

