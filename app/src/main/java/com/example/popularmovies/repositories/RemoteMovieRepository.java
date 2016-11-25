package com.example.popularmovies.repositories;

import com.example.popularmovies.BuildConfig;
import com.example.popularmovies.api.MoviesDbModule;
import com.example.popularmovies.api.payoads.MoviesPayload;
import com.example.popularmovies.values.MovieInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteMovieRepository implements MoviesRepository {

    @Override
    public void fetchPopMovies(final OnMoviesListReceivedListener listener) {

        Call<MoviesPayload> call = MoviesDbModule.moviesDbService().fetchPopularMovies(BuildConfig.API_KEY);
        call.enqueue(new Callback<MoviesPayload>() {
            @Override
            public void onResponse(Call<MoviesPayload> call, Response<MoviesPayload> response) {
                handleSuccessResponse(response, listener);
            }

            @Override
            public void onFailure(Call<MoviesPayload> call, Throwable t) {
                listener.onRequestFail();
            }
        });
    }

    @Override
    public void fetchTopRatedMovies(final OnMoviesListReceivedListener listener) {
        Call<MoviesPayload> call = MoviesDbModule.moviesDbService().fetchToRatedMovies(BuildConfig.API_KEY);
        call.enqueue(new Callback<MoviesPayload>() {
            @Override
            public void onResponse(Call<MoviesPayload> call, Response<MoviesPayload> response) {
                handleSuccessResponse(response, listener);
            }

            @Override
            public void onFailure(Call<MoviesPayload> call, Throwable t) {
                listener.onRequestFail();
            }
        });
    }

    private void handleSuccessResponse(Response<MoviesPayload> response, OnMoviesListReceivedListener listener) {
        if (response.isSuccessful()) {
            List<MovieInfo> movies = response.body().toMovies();
            listener.onMoviesReceived(movies);
        }
    }
}
