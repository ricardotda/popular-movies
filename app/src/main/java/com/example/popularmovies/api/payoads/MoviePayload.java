package com.example.popularmovies.api.payoads;

import com.example.popularmovies.values.MovieInfo;
import com.google.gson.annotations.SerializedName;

public class MoviePayload {

    @SerializedName("poster_path") private String posterPath;
    @SerializedName("adult") private boolean adult;
    @SerializedName("overview") private String overview;
    @SerializedName("release_date") private String releaseDate;
    @SerializedName("genre_ids") private int[] genreIds;
    @SerializedName("id") private int id;
    @SerializedName("original_title") private String originalTitle;
    @SerializedName("original_language") private String originalLanguage;
    @SerializedName("title") private String title;
    @SerializedName("backdrop_path") private String backdropPath;
    @SerializedName("popularity") private float popularity;
    @SerializedName("video") private boolean video;
    @SerializedName("vote_count") private int voteCount;
    @SerializedName("vote_average") private float voteAverage;

    public MovieInfo toMovieInfo() {
        return new MovieInfo(
                posterPath,
                adult,
                overview,
                releaseDate,
                genreIds,
                id,
                originalTitle,
                originalLanguage,
                title,
                backdropPath,
                popularity,
                video,
                voteCount,
                voteAverage);
    }
}
