package com.example.popularmovies.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.popularmovies.R;
import com.example.popularmovies.values.MovieInfo;
import com.squareup.picasso.Picasso;

public class MovieDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE_INFO = "extra_movie_info";

    private static final int MAX_VOTE_RATING = 10;
    private ImageView moviePoster;
    private TextView releaseDate;
    private TextView voteAverage;
    private TextView synopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        moviePoster = (ImageView) findViewById(R.id.movie_poster);
        releaseDate = (TextView) findViewById(R.id.release_date);
        voteAverage = (TextView) findViewById(R.id.vote_average);
        synopsis = (TextView) findViewById(R.id.synopsis);

        setupToolBar();

        MovieInfo movieInfo = (MovieInfo) getIntent().getSerializableExtra(EXTRA_MOVIE_INFO);
        setupMovieDetails(movieInfo);

        setTitle(movieInfo.getTitle());
    }

    private void setupToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupMovieDetails(MovieInfo movieInfo) {
        Picasso.with(this).load(movieInfo.getCompletePosterPath()).into(moviePoster);
        releaseDate.setText(extractYear(movieInfo));
        voteAverage.setText(String.format(
                getString(R.string.vote_average),
                String.valueOf(movieInfo.getVoteAverage()),
                String.valueOf(MAX_VOTE_RATING)));
        synopsis.setText(movieInfo.getOverview());
    }

    @NonNull
    private String extractYear(MovieInfo movieInfo) {
        return movieInfo.getReleaseDate().substring(0, 4);
    }
}
