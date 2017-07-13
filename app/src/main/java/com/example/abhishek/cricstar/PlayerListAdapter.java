package com.example.abhishek.cricstar;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by abhishek on 13/07/17.
 */

public class PlayerListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private RecyclerView mRecyclerView,mRecyclerView2;
    private RecyclerView.Adapter playerListAdapterTwo;
    private RecyclerView.LayoutManager mLayoutManager,mLayoutManager2;
    private Context context;

    public List<PlayersListResponse.Squad> squadList;

    public PlayerListAdapter(List<PlayersListResponse.Squad> squadList, Context context){
        this.squadList = squadList;
        this.context=context;
        //this.mLayoutManager=mLayoutManager;




    }
    public class ViewHolder0 extends RecyclerView.ViewHolder{
        private TextView country_name;

        public ViewHolder0(View view){
            super(view);
            country_name=view.findViewById(R.id.country_name);
            mRecyclerView2 = (RecyclerView) view.findViewById(R.id.players_recycler_view_2);

            mLayoutManager = new LinearLayoutManager(context);

            mRecyclerView2.setLayoutManager(mLayoutManager);



        }
    }



    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        ViewHolder0 viewHolder0 = new ViewHolder0(LayoutInflater.from(parent.getContext()).inflate(R.layout.country_list,parent,false));
        return viewHolder0;


    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i){
        ViewHolder0 viewHolder0 = (ViewHolder0)holder;


            viewHolder0.country_name.setText(squadList.get(i).getCountryName());
        playerListAdapterTwo = new PlayerListAdapterTwo(squadList.get(i).getPlayers());
            mRecyclerView2.setAdapter(playerListAdapterTwo);


    }
    public int getItemCount(){

        return squadList.size();
    }
}
