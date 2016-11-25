package com.example.popularmovies.api;

import com.example.popularmovies.api.payoads.MoviesPayload;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesDbApi {

    @GET("/3/movie/popular")
    Call<MoviesPayload> fetchPopularMovies(
            @Query("api_key") String apiKey
    );

    @GET("/3/movie/top_rated")
    Call<MoviesPayload> fetchToRatedMovies(
            @Query("api_key") String apiKey
    );
}
