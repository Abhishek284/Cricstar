package com.example.abhishek.cricstar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhishek on 09/07/17.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<DataParse.Matches> matchesListxx = new ArrayList<DataParse.Matches>();

    public class ViewHolder0 extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView,mTextView2,serial_no,date_view;

        public ViewHolder0(View v) {
            super(v);
            mTextView = v.findViewById(R.id.team_name);
            mTextView2= v.findViewById(R.id.team_name2);
            serial_no = v.findViewById(R.id.serial_no);
            date_view=v.findViewById(R.id.date);
        }
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder{
        public TextView numberView;

        public ViewHolder1(View v){
            super(v);
            numberView = v.findViewById(R.id.team_id);

        }

    }

    public MyAdapter(List<DataParse.Matches> x){
        this.matchesListxx = x;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        switch (viewType){
            case 0:
                return new ViewHolder0(LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view,parent,false));

            case 1:
                return new ViewHolder1(LayoutInflater.from(parent.getContext()).inflate(R.layout.my_number_view,parent,false));
            default: return null;
        }

//        View v =  LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.my_text_view, parent, false);
//        // set the view's size, margins, paddings and layout parameters
//
//        ViewHolder0 vh = new ViewHolder0(v);
//        return vh;

    }

//    public int getItemViewType(int position){
//        if (position >= matchesListxx.size()) {
//            return 1;
//        }
//        else
//            return 0;
//        return position%2;
//    }


    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        switch (holder.getItemViewType()){
            case 0:
            ViewHolder0 viewHolder0 = (ViewHolder0)holder;
                viewHolder0.mTextView.setText(matchesListxx.get(position).getTeam1());
                viewHolder0.mTextView2.setText(matchesListxx.get(position).getTeam2());
                viewHolder0.serial_no.setText(String.valueOf(position+1));
                //viewHolder0.date_view.setText(matchesListxx.get(position).getDate());
                break;
            case 1:
                ViewHolder1 viewHolder1 =(ViewHolder1)holder;
                viewHolder1.numberView.setText(String.valueOf(matchesListxx.get(position).getUnique_id()));

        }

    }
    public int getItemCount() {
        return matchesListxx.size();
    }

}
