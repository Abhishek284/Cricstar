package com.example.abhishek.cricstar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by abhishek on 04/07/17.
 */

public class LoginActivity extends AppCompatActivity {

   public void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
localTest asd = new localTest();
       GitHubClient client = localTest.ABC();
       Call<GitHubRepo> xx = client.getTopRatedMovies("5C1QA2CZnqhcZgcgSc64ok2PpJy2");
       xx.enqueue(new Callback<GitHubRepo>() {
           @Override
           public void onResponse(Call<GitHubRepo> call, Response<GitHubRepo> response) {

           }

           @Override
           public void onFailure(Call<GitHubRepo> call, Throwable t) {

           }
       });
   }


    //https://futurestud.io/tutorials/gson-getting-started-with-java-json-serialization-deserialization
    //https://futurestud.io/tutorials/retrofit-getting-started-and-android-client


}
