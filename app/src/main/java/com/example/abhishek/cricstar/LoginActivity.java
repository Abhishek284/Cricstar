package com.example.abhishek.cricstar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by abhishek on 04/07/17.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    List<DataParse.Matches> matchesListxx = new ArrayList<DataParse.Matches>();

    public String source;
    public String d ;
    public int creditsLeft;
    public Button login;
    private ProgressBar spinner;

    CharSequence text = "API call Successfull";
    int duration = Toast.LENGTH_SHORT;



    @Override
   public void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
       // CallApiAllMatches();


   }

    public void onResume(){
        super.onResume();

        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        login = (Button) findViewById(R.id.login_button);
        login.setOnClickListener(this);

    }
    public void onClick(View v){
        System.out.println("Calling the API");
        CallApiAllMatches();
        spinner.setVisibility(View.VISIBLE);

    }

    public void onSuccess(){
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);

    }
    public void showToast()
    {
         Toast.makeText(this, text, duration).show();
    }




    public void CallApiAllMatches(){

        CricketEndpoints client = UrlBaseHandler.BaseUrl();
        Call<DataParse> call = client.getAllUpcomingMatches(AllStrings.API_KEY);
        call.enqueue(new Callback<DataParse>() {
            @Override
            public void onResponse(Call<DataParse> call, Response<DataParse> response) {

                spinner.setVisibility(View.GONE);
                showToast();

                matchesListxx = response.body().getMatchesList();
                source = response.body().getProvider().getSource();
                creditsLeft = response.body().getCreditsLeft();
                d= response.body().getV();
                System.out.println("There you go"+" "+ matchesListxx.get(2).getUnique_id() + " " + source +" " + d +" "+ creditsLeft);
                onSuccess();
            }
            @Override
            public void onFailure(Call<DataParse> call, Throwable t) {
                System.out.println("failed");
            }

        });


    }


    //Refrerences
    // https://futurestud.io/tutorials/gson-getting-started-with-java-json-serialization-deserialization
    //https://futurestud.io/tutorials/retrofit-getting-started-and-android-client


}
