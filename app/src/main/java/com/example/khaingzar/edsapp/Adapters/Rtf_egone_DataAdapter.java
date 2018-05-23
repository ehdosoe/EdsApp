package com.example.khaingzar.edsapp.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.khaingzar.edsapp.Models.Rtf_egone_Movies;
import com.example.khaingzar.edsapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Khaing Zar on 5/21/2018.
 */

public class Rtf_egone_DataAdapter extends RecyclerView.Adapter<Rtf_egone_DataAdapter.ViewHolder> {
    private ArrayList<Rtf_egone_Movies> movies;

    public Rtf_egone_DataAdapter(ArrayList<Rtf_egone_Movies> movies) {
        this.movies=movies;
    }

    @Override
    public Rtf_egone_DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rtf_egone_movie_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final Rtf_egone_DataAdapter.ViewHolder viewHolder, int i) {

        final Context context=viewHolder.img.getContext();

        viewHolder.tv_name.setText(movies.get(i).getName());
        viewHolder.tv_description.setText(movies.get(i).getDescription());
        viewHolder.tv_rating.setText(movies.get(i).getRating());
        viewHolder.tv_spsode.setText(Integer.toString(movies.get(i).getEpisode()));
        viewHolder.tv_studio.setText(movies.get(i).getStudio());
        viewHolder.tv_category.setText(movies.get(i).getCategorie());
        String url=movies.get(i).getImg();
        Picasso.with(context).load(url).into(viewHolder.img);

        viewHolder.movie_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Test Click"+String.valueOf(viewHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name,tv_description,tv_rating,tv_studio,tv_spsode,tv_category;
        private ImageView img;
        private CardView movie_card;
        public ViewHolder(View view) {
            super(view);
            movie_card=(CardView)view.findViewById(R.id.movie_card);
            tv_name=(TextView) view.findViewById(R.id.mov_title);
            tv_description=(TextView) view.findViewById(R.id.mov_description);
            tv_rating=(TextView) view.findViewById(R.id.mov_rate);
            tv_spsode=(TextView) view.findViewById(R.id.mov_epsode);
            tv_studio=(TextView) view.findViewById(R.id.mov_studio);
            tv_category=(TextView) view.findViewById(R.id.mov_category);
            img=(ImageView)view.findViewById(R.id.mov_thumbnail);
        }
    }
}
