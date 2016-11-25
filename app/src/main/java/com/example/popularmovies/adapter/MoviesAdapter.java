package com.example.popularmovies.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.popularmovies.R;
import com.example.popularmovies.values.MovieInfo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private final Picasso picasso;
    private final List<MovieInfo> movieInfoList;
    private OnMovieSelectListener listener;

    public MoviesAdapter(Context context, List<MovieInfo> movieInfoList, OnMovieSelectListener listener) {
        picasso = Picasso.with(context);
        this.movieInfoList = movieInfoList;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        MovieInfo movieInfo = movieInfoList.get(position);
        holder.movieInfo = movieInfo;

        picasso.load(movieInfo.getCompletePosterPath()).into(holder.thumbnail);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != listener) {
                    listener.onSelectMovie(holder.movieInfo);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        View view;
        ImageView thumbnail;
        MovieInfo movieInfo;

        ViewHolder(View view) {
            super(view);
            this.view = view;
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }

    public interface OnMovieSelectListener {
        void onSelectMovie(MovieInfo movieInfo);
    }
}
