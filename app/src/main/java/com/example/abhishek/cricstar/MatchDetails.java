package com.example.abhishek.cricstar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchDetails extends AppCompatActivity {
    private long unique_id;
    private List squadList;
    private List playerlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_details);
        Intent intent = getIntent();
        unique_id = intent.getLongExtra("unique_id", unique_id);
        callPlayerList(unique_id);

    }
    public class ReqBody{
        private String apikey;
        private Long unique_id;
        public ReqBody(String apikey, Long unique_id){
            this.apikey=apikey;
            this.unique_id=unique_id;

        }

    }




    private void callPlayerList(long unique_id) {
        final MatchDetails.ReqBody reqBody = new MatchDetails.ReqBody("ScTdY9xQdyUfr0CxWybjHZPHMHC3",unique_id);


        CricketEndpoints client = UrlBaseHandler.BaseUrl();
        Call<PlayersList> call = client.getAllPlayerList("application/json",reqBody);
        call.enqueue(new Callback<PlayersList>() {
            @Override
            public void onResponse(Call<PlayersList> call, Response<PlayersList> response) {


//                spinner.setVisibility(View.GONE);
//                showToast();
                squadList = response.body().getSquad();
                playerlist = response.body().getSquad().get(1).getPlayers();
                System.out.println("Success" + " "+ response.code());
//                matchesListxx = response.body().getMatchesList();
//                source = response.body().getProvider().getSource();
//                creditsLeft = response.body().getCreditsLeft();
//                d= response.body().getV();
//                System.out.println("There you go"+" "+ matchesListxx.get(2).getUnique_id() + " " + source +" " + d +" "+ creditsLeft);
//                mAdapter = new MyAdapter(matchesListxx,DashboardActivity.this);
//                mRecyclerView.setAdapter(mAdapter);
//                CreditsLeftText.setText(String.valueOf(response.body().getCreditsLeft()));
//                SourceText.setText(String.valueOf(response.body().getProvider().getSource()));





            }

            @Override
            public void onFailure(Call<PlayersList> call, Throwable t) {
                System.out.println("failed");
            }

        });
    }



}
