package com.example.abhishek.cricstar;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchDetails extends AppCompatActivity {
    private CharSequence text = "Player List Not available";
    private int duration = Toast.LENGTH_SHORT;
    private long unique_id;
    private List<PlayersListResponse.Squad> squadList;
    private List playerlist;
    private RecyclerView mRecyclerView,mRecyclerView2;
    private RecyclerView.Adapter countryListAdapter;
    private RecyclerView.LayoutManager mLayoutManager,mLayoutManager2;
    private ArrayList arrayList = new ArrayList();
    private ProgressBar spinner;
    private int arrayIndex=0,playerListSize=0,playerListIndex =0,squadIndex=0,squadSize =0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_details);
        Intent intent = getIntent();
        unique_id = intent.getLongExtra("unique_id", unique_id);
        callPlayerList(unique_id);
        spinner = (ProgressBar) findViewById(R.id.progressBar_matchdetails);
        spinner.setVisibility(View.VISIBLE);


        mRecyclerView = (RecyclerView) findViewById(R.id.players_recycler_view);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


    }
    public class ReqBody{
        private String apikey;
        private Long unique_id;
        public ReqBody(String apikey, Long unique_id){
            this.apikey=apikey;
            this.unique_id=unique_id;

        }

    }
    private void showToast()
    {
        Toast.makeText(this, text, duration).show();
    }

    private ArrayList generateArrayList(PlayersListResponse response){
        while (squadSize!=0){
            arrayList.add(arrayIndex,response.getSquad().get(squadIndex).getCountryName());
            arrayIndex++;
            playerListSize = response.getSquad().get(squadIndex).getPlayers().size();
            while (playerListSize!=0){
                arrayList.add(arrayIndex,response.getSquad().get(squadIndex).getPlayers().get(playerListIndex).getPlayerName());
                playerListSize--;
                playerListIndex++;
                arrayIndex++;
            }
            playerListSize=0;
            playerListIndex=0;
            squadSize--;
            squadIndex++;

        }

        return arrayList;
    }




    private void callPlayerList(long unique_id) {
        final MatchDetails.ReqBody reqBody = new MatchDetails.ReqBody(AllStrings.API_KEY,unique_id);


        CricketEndpoints client = UrlBaseHandler.BaseUrl();
        Call<PlayersListResponse> call = client.getAllPlayerList("application/json",reqBody);
        call.enqueue(new Callback<PlayersListResponse>() {
            @Override
            public void onResponse(Call<PlayersListResponse> call, Response<PlayersListResponse> response) {



                spinner.setVisibility(View.GONE);
                squadList = response.body().getSquad();
                System.out.println("Success" + " "+ response.code());
                squadSize = squadList.size();
                if(squadList.size()>0) {
                    arrayList = generateArrayList(response.body());
                    System.out.println(arrayList.size());

                    countryListAdapter = new CountryListAdapter(squadList, getApplicationContext(),arrayList);
                    mRecyclerView.setAdapter(countryListAdapter);
                }

                else {
                    showToast();
                }







            }

            @Override
            public void onFailure(Call<PlayersListResponse> call, Throwable t) {
                System.out.println("failed");
            }

        });
    }



}
