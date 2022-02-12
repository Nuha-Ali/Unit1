package com.nuhaali.flixster.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nuhaali.flixster.R;
import com.nuhaali.flixster.models.Movie;

import java.util.List;

// to define the adapter then it will ask to implement 3 methods
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    //key contents that will be held by the adapter
    Context context;
    List<Movie> movies;
    //generate constructors

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }
    // Usually involves inflating a Layout from XML and returning the holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("MovieAdapter", "onCreateViewHolder");
        View movieView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent,false);
        return null;
    }
    //involves populating data into the item through holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("MpvieAdopter", "onBindViewHolder"+ position);
        // first will get the movie at the passed in position
        Movie movie = movies.get(position);
        //then bind the movie data into the VH
        holder.bind(movie);//it will create bind method for us


    }
    //Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return movies.size();
    }

    //1.display the view in item_movie also defined the viewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        TextView tvOverview;
        ImageView ivPoster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //2.to know where we can find the elements
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvOverview = itemView.findViewById(R.id.tvOverview);
            ivPoster = itemView.findViewById(R.id.ivPoster);
        }

        public void bind(Movie movie) {
            tvTitle.setText(movie.getTitle());
            tvOverview.setText(movie.getOverview());
            String imageUrl;
            // if phone is in the landscape
            if(context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                //then imageurl= back drop image
                imageUrl = movie.getBackdropPath();
            }else{
                imageUrl = movie.getPosterPath();
            }
            Glide.with(context).load(imageUrl).into(ivPoster);
        }
    }
}

