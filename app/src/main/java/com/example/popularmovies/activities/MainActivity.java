package com.example.popularmovies.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.popularmovies.R;
import com.example.popularmovies.adapter.MoviesAdapter;
import com.example.popularmovies.repositories.MoviesRepository;
import com.example.popularmovies.repositories.Repositories;
import com.example.popularmovies.values.MovieInfo;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MoviesRepository.OnMoviesListReceivedListener, MoviesAdapter.OnMovieSelectListener {

    private static final int COLUMNS_NUMBER = 2;
    private static final int FILTER_POP_MOVIES = 0;
    private static final int FILTER_TOP_RATED = 1;

    private RecyclerView moviesView;
    private ProgressBar loadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.filter);
        moviesView = (RecyclerView) findViewById(R.id.movies_view);
        loadingView = (ProgressBar) findViewById(R.id.loading_view);
        moviesView.setLayoutManager(new GridLayoutManager(this, COLUMNS_NUMBER));

        setupToolBar();
        setupFilterOptions(spinner);
        fetchPopMovies();
    }

    private void setupToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void setupFilterOptions(Spinner spinner) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.filter_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position) {
                    case FILTER_POP_MOVIES:
                        fetchPopMovies();
                        break;
                    case FILTER_TOP_RATED:
                        fetchTopRatedMovies();
                        break;
                }
            }

            @Override public void onNothingSelected(AdapterView<?> adapterView) { }
        });
    }

    private void fetchPopMovies() {
        Repositories.repository().forMovies().fetchPopMovies(this);
    }

    private void fetchTopRatedMovies() {
        Repositories.repository().forMovies().fetchTopRatedMovies(this);
    }

    @Override
    public void onMoviesReceived(List<MovieInfo> movieInfoList) {
        loadingView.setVisibility(View.GONE);
        moviesView.setAdapter(new MoviesAdapter(this, movieInfoList, this));
    }

    @Override
    public void onRequestFail() {
        loadingView.setVisibility(View.GONE);
        Toast.makeText(this, R.string.connection_fail, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSelectMovie(MovieInfo movieInfo) {
        Intent intent = new Intent(this, MovieDetailsActivity.class);
        intent.putExtra(MovieDetailsActivity.EXTRA_MOVIE_INFO, movieInfo);
        startActivity(intent);
    }
}
