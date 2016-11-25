package com.example.popularmovies.values;

import com.example.popularmovies.BuildConfig;

import java.io.Serializable;

public class MovieInfo implements Serializable {

    private static final long serialVersionUID = -2228936827996568888L;

    private String posterPath;
    private boolean adult;
    private String overview;
    private String releaseDate;
    private int[] genreIds;
    private int id;
    private String originalTitle;
    private String originalLanguage;
    private String title;
    private String backdropPath;
    private float popularity;
    private boolean video;
    private int voteCount;
    private float voteAverage;

    public MovieInfo(String posterPath, boolean adult, String overview, String releaseDate,
                     int[] genreIds, int id, String originalTitle, String originalLanguage,
                     String title, String backdropPath, float popularity, boolean video,
                     int voteCount, float voteAverage) {
        this.posterPath = posterPath;
        this.adult = adult;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.genreIds = genreIds;
        this.id = id;
        this.originalTitle = originalTitle;
        this.originalLanguage = originalLanguage;
        this.title = title;
        this.backdropPath = backdropPath;
        this.popularity = popularity;
        this.video = video;
        this.voteCount = voteCount;
        this.voteAverage = voteAverage;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public int[] getGenreIds() {
        return genreIds;
    }

    public int getId() {
        return id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getTitle() {
        return title;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public float getPopularity() {
        return popularity;
    }

    public boolean isVideo() {
        return video;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public String getCompletePosterPath() {
        return BuildConfig.IMAGE_BASE_URL + BuildConfig.SIZE + getPosterPath();
    }
}
