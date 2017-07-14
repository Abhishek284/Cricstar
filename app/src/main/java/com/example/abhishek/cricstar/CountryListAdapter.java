package com.example.abhishek.cricstar;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhishek on 13/07/17.
 */

public class CountryListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private RecyclerView mRecyclerView,mRecyclerView2;
    private RecyclerView.Adapter playerListAdapterTwo;
    private RecyclerView.LayoutManager mLayoutManager,mLayoutManager2;
    private Context context;
    private ArrayList arrayList;
    private int viewtype;
    int serial_no = 1;


    public List<PlayersListResponse.Squad> squadList;

    public CountryListAdapter(List<PlayersListResponse.Squad> squadList, Context context,ArrayList arrayList){
        this.arrayList= arrayList;
        this.squadList = squadList;
        this.context=context;




    }
    public class ViewHolder0 extends RecyclerView.ViewHolder{
        private TextView country_name;

        public ViewHolder0(View view){
            super(view);
            country_name=view.findViewById(R.id.country_name);



//          Use for nested recycler iew
//            mRecyclerView2 =  view.findViewById(R.id.players_recycler_view_2);
//            mLayoutManager = new LinearLayoutManager(context);
//            mRecyclerView2.setLayoutManager(mLayoutManager);



        }
    }
    public class ViewHolder1 extends RecyclerView.ViewHolder{
        private TextView player_nameview;

        public ViewHolder1(View view){
            super(view);
            player_nameview=view.findViewById(R.id.new_player_name);





        }
    }
    @Override
    public int getItemViewType(int position){
        viewtype =1;
        for (PlayersListResponse.Squad squad : squadList) {
            if (squad.getCountryName().contains(arrayList.get(position).toString())) {
                viewtype = 0;
                break;
            }

    }
        return viewtype;
    }




    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        switch (viewType){
            case 0:
                ViewHolder0 viewHolder0 = new ViewHolder0(LayoutInflater.from(parent.getContext()).inflate(R.layout.country_list,parent,false));
                return viewHolder0;
            case 1:
                ViewHolder1 viewHolder1 = new ViewHolder1(LayoutInflater.from(parent.getContext()).inflate(R.layout.my_player_name_view,parent,false));
                return viewHolder1;
            default:return null;
        }



    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i){
        switch (holder.getItemViewType()){
            case 0:
                ViewHolder0 viewHolder0 = (ViewHolder0)holder;
                viewHolder0.country_name.setText(arrayList.get(i).toString());
                break;
            case 1:
                ViewHolder1 viewHolder1 = (ViewHolder1)holder;
                viewHolder1.player_nameview.setText(arrayList.get(i).toString());
                break;

        }
// Used for Nested recycler view
//        ViewHolder0 viewHolder0 = (ViewHolder0)holder;
//        viewHolder0.country_name.setText(squadList.get(i).getCountryName());
//
//
//        playerListAdapterTwo = new PlayerListAdapter(squadList.get(i).getPlayers());
//            mRecyclerView2.setAdapter(playerListAdapterTwo);


    }
    @Override
    public int getItemCount(){

        return arrayList.size();
    }


}
