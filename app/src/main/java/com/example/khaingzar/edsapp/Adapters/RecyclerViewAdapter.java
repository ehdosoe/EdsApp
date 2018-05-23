package com.example.khaingzar.edsapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.khaingzar.edsapp.Models.Movie;
import com.example.khaingzar.edsapp.R;

import java.util.List;

/**
 * Created by Khaing Zar on 5/19/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Movie> mData;

    public RecyclerViewAdapter(Context mContext, List<Movie> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v= LayoutInflater.from(mContext).inflate(R.layout.movie_list_row,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.title.setText(mData.get(position).getTitle());
        holder.gene.setText(mData.get(position).getGenre());
        holder.year.setText(mData.get(position).getYear());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private TextView gene;
        private TextView year;

        public MyViewHolder(View itemView) {
            super(itemView);

            title=(TextView)itemView.findViewById(R.id.title);
            gene=(TextView)itemView.findViewById(R.id.genre);
            year=(TextView) itemView.findViewById(R.id.year);
        }
    }
}
