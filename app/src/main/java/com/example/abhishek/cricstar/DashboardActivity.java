package com.example.abhishek.cricstar;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener,MyListener{
    List<DataParse.Matches> matchesListxx = new ArrayList<DataParse.Matches>();

    private String source;
    private String d ;
    private int creditsLeft;
    private CharSequence text = "API call Successfull";
    private int duration = Toast.LENGTH_SHORT;
    private ProgressBar spinner;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private TextView CreditsLeftText,SourceText;
    private android.view.MenuItem menuItem;
    private View view ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        spinner.setVisibility(View.VISIBLE);
        callApiAllMatches();
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar,menu);
        menuItem = (MenuItem) findViewById(R.id.action_favorite);

        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
        return true;

    }
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);

    }
    public void callDetails(long i){
        Intent intent = new Intent(this,MatchDetails.class);

        startActivity(intent);


    }



    protected void onResume(){
        super.onResume();
        CreditsLeftText = (TextView) findViewById(R.id.credits_left);
        SourceText = (TextView) findViewById(R.id.source_text);


    }





    private void showToast()
    {
        Toast.makeText(this, text, duration).show();
    }

    public void onClick(View v){

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }




    private void callApiAllMatches() {

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
                mAdapter = new MyAdapter(matchesListxx,DashboardActivity.this);
                mRecyclerView.setAdapter(mAdapter);
                CreditsLeftText.setText(String.valueOf(response.body().getCreditsLeft()));
                SourceText.setText(String.valueOf(response.body().getProvider().getSource()));





            }

            @Override
            public void onFailure(Call<DataParse> call, Throwable t) {
                System.out.println("failed");
            }

        });
    }
}
