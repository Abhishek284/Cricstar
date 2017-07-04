package com.example.abhishek.cricstar;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by abhishek on 04/07/17.
 */

public interface GitHubClient {
    @GET("/api/matches")
    Call<GitHubRepo> getTopRatedMovies(@Query("apikey") String apiKey);

}

