package com.example.abhishek.cricstar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by abhishek on 04/07/17.
 */

public class LoginActivity extends AppCompatActivity {

@Override
   public void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);

       // UrlBaseHandler asd = new UrlBaseHandler();
        CricketEndpoints client = UrlBaseHandler.BaseUrl();
        Call<DataParse> xx = client.getAllUpcomingMatches("5C1QA2CZnqhcZgcgSc64ok2PpJy2");
        xx.enqueue(new Callback<DataParse>() {
           @Override
           public void onResponse(Call<DataParse> call, Response<DataParse> response) {


           }

           @Override
           public void onFailure(Call<DataParse> call, Throwable t) {


           }
       });
   }


    //https://futurestud.io/tutorials/gson-getting-started-with-java-json-serialization-deserialization
    //https://futurestud.io/tutorials/retrofit-getting-started-and-android-client


}
