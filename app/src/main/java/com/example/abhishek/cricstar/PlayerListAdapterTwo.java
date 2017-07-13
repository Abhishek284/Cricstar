package com.example.abhishek.cricstar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by abhishek on 13/07/17.
 */

public class PlayerListAdapterTwo extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public List<PlayersListResponse.Squad.Players> playersList;

    public PlayerListAdapterTwo(List<PlayersListResponse.Squad.Players> playersList){
        this.playersList = playersList;


    }
    public class ViewHolder0 extends RecyclerView.ViewHolder{
        private TextView player_name;

        public ViewHolder0(View view){
            super(view);
            player_name=view.findViewById(R.id.player_name);


        }
    }



    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        ViewHolder0 viewHolder0 = new ViewHolder0(LayoutInflater.from(parent.getContext()).inflate(R.layout.player_list,parent,false));
        return viewHolder0;


    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i){
        ViewHolder0 viewHolder0 = (ViewHolder0)holder;


            viewHolder0.player_name.setText(String.valueOf(i+1)+"."+" "+playersList.get(i).getPlayerName());

    }
    public int getItemCount(){

        return playersList.size();
    }
}
