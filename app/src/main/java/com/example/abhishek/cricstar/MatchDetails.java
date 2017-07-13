package com.example.abhishek.cricstar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchDetails extends AppCompatActivity {
    private CharSequence text = "Player List Not available";
    private int duration = Toast.LENGTH_SHORT;
    private long unique_id;
    private List squadList;
    private List playerlist;
    private RecyclerView mRecyclerView,mRecyclerView2;
    private RecyclerView.Adapter playerListAdapter;
    private RecyclerView.LayoutManager mLayoutManager,mLayoutManager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_details);
        Intent intent = getIntent();
        unique_id = intent.getLongExtra("unique_id", unique_id);
        callPlayerList(unique_id);

        mRecyclerView = (RecyclerView) findViewById(R.id.players_recycler_view);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

//        mRecyclerView2 = (RecyclerView) findViewById(R.id.players_recycler_view_2);
       mLayoutManager2 = new LinearLayoutManager(this);
//        mRecyclerView2.setLayoutManager(mLayoutManager2);

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




    private void callPlayerList(long unique_id) {
        final MatchDetails.ReqBody reqBody = new MatchDetails.ReqBody("ScTdY9xQdyUfr0CxWybjHZPHMHC3",unique_id);


        CricketEndpoints client = UrlBaseHandler.BaseUrl();
        Call<PlayersListResponse> call = client.getAllPlayerList("application/json",reqBody);
        call.enqueue(new Callback<PlayersListResponse>() {
            @Override
            public void onResponse(Call<PlayersListResponse> call, Response<PlayersListResponse> response) {


//                spinner.setVisibility(View.GONE);
//                showToast();
                squadList = response.body().getSquad();
                //playerlist = response.body().getSquad().get(1).getPlayers();
                System.out.println("Success" + " "+ response.code());

                if(squadList.size()>0) {

                    playerListAdapter = new PlayerListAdapter(squadList, getApplicationContext());
                    mRecyclerView.setAdapter(playerListAdapter);
                }

                else {
                    showToast();
                }

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
            public void onFailure(Call<PlayersListResponse> call, Throwable t) {
                System.out.println("failed");
            }

        });
    }



}
