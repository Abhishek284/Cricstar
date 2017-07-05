package com.example.abhishek.cricstar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by abhishek on 04/07/17.
 */

public class LoginActivity extends AppCompatActivity {
    List<DataParse.Matches> matchesListxx = new ArrayList<DataParse.Matches>();

    public String source;
    public String d ;
    public int creditsLeft;


    @Override
   public void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);

       // UrlBaseHandler asd = new UrlBaseHandler();
        CricketEndpoints client = UrlBaseHandler.BaseUrl();
        Call<DataParse> xx = client.getAllUpcomingMatches("5C1QA2CZnqhcZgcgSc64ok2PpJy2");
        xx.enqueue(new Callback<DataParse>() {
           @Override
           public void onResponse(Call<DataParse> call, Response<DataParse> response) {


               Gson gson = new Gson();
               String result = gson.toJson(response.body());
               //abc = gson.fromJson(, DataParse.class);
                System.out.println("passed");
               System.out.println(result);
               System.out.println(response.body());
               System.out.println(response);
               System.out.println(response.code());
               System.out.println(response.message());
               DataParse abc = new DataParse();
               matchesListxx = response.body().getMatchesList();
               source = response.body().getProvider().getSource();
               creditsLeft = response.body().getCreditsLeft();

               d= response.body().getV();
               System.out.println("There you go"+" "+ matchesListxx.get(2).getUnique_id() + " " + source +" " + d +" "+ creditsLeft);
               //System.out.println("Abhi"+ "matchesList" + matchesListxx.size());









           }

           @Override
           public void onFailure(Call<DataParse> call, Throwable t) {
               System.out.println("failed");


           }

       });


   }


    //https://futurestud.io/tutorials/gson-getting-started-with-java-json-serialization-deserialization
    //https://futurestud.io/tutorials/retrofit-getting-started-and-android-client


}
