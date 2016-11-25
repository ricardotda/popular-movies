package com.example.popularmovies.repositories;

import com.example.popularmovies.values.MovieInfo;

import java.util.List;

public interface MoviesRepository {

    interface OnMoviesListReceivedListener {
        void onMoviesReceived(List<MovieInfo> movieInfoList);
        void onRequestFail();
    }

    void fetchPopMovies(OnMoviesListReceivedListener listener);
    void fetchTopRatedMovies(OnMoviesListReceivedListener listener);
}
