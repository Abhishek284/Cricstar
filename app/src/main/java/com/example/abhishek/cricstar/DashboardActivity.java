package com.example.abhishek.cricstar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {
    List<DataParse.Matches> matchesListxx = new ArrayList<DataParse.Matches>();

    public String source;
    public String d ;
    public int creditsLeft;
    CharSequence text = "API call Successfull";
    int duration = Toast.LENGTH_SHORT;
    private ProgressBar spinner;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        spinner.setVisibility(View.VISIBLE);
        CallApiAllMatches();
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
//        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)

    }

    protected void onResume(){
        super.onResume();


    }

    public void showToast()
    {
        Toast.makeText(this, text, duration).show();
    }




    public void CallApiAllMatches() {

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
                mAdapter = new MyAdapter(matchesListxx);
                mRecyclerView.setAdapter(mAdapter);


            }

            @Override
            public void onFailure(Call<DataParse> call, Throwable t) {
                System.out.println("failed");
            }

        });
    }
}
