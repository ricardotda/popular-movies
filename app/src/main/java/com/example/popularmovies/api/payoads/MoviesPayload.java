package com.example.popularmovies.api.payoads;

import com.example.popularmovies.values.MovieInfo;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MoviesPayload {

    @SerializedName("results") private List<MoviePayload> moviePayloads;

    public List<MovieInfo> toMovies() {
        List<MovieInfo> movieInfoList = new ArrayList<>();
        for (MoviePayload moviePayload : moviePayloads) {
            movieInfoList.add(moviePayload.toMovieInfo());
        }
        return movieInfoList;
    }
}
