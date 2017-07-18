package com.example.abhishek.cricstar;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
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
    private ArrayList<ArrayListModalClass> arrayList;
    private int viewtype;


    public List<PlayersListResponse.Squad> squadList;

    public CountryListAdapter(List<PlayersListResponse.Squad> squadList, Context context,ArrayList<ArrayListModalClass> arrayList){
        this.arrayList= arrayList;
        this.squadList = squadList;
        this.context=context;




    }
    public class ViewHolder0 extends RecyclerView.ViewHolder{
        private TextView country_name;
        private EditText country_name_edit;


        public ViewHolder0(final View view){
            super(view);
            country_name=view.findViewById(R.id.country_name);
            country_name_edit = view.findViewById(R.id.country_name_edit_text);
            country_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    country_name.setVisibility(View.GONE);
                    country_name_edit.setVisibility(View.VISIBLE);
                    country_name_edit.setText(country_name.getText());
                }
            });
            country_name_edit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if(i== EditorInfo.IME_ACTION_DONE){
                        country_name.setText(country_name_edit.getText());
                        country_name_edit.setVisibility(View.GONE);
                        country_name.setVisibility(View.VISIBLE);
                        Intent intent = new Intent();
                        intent.setAction("com.test.CUSTOM_INTENT");
                        context.sendBroadcast(intent);
                        return true;
                    }
                    else {
                        return false;
                    }

                }
            });

//          Use for nested recycler iew
//            mRecyclerView2 =  view.findViewById(R.id.players_recycler_view_2);
//            mLayoutManager = new LinearLayoutManager(context);
//            mRecyclerView2.setLayoutManager(mLayoutManager);



        }}



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
            if (squad.getCountryName().contains(arrayList.get(position).getName())) {
            //if (squad.getCountryName().contains(arrayList.get(position).toString())) {
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
                viewHolder0.country_name.setText(arrayList.get(i).getName());
                break;
            case 1:
                ViewHolder1 viewHolder1 = (ViewHolder1)holder;
                viewHolder1.player_nameview.setText(arrayList.get(i).getSerial()+1+". "+arrayList.get(i).getName());
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
