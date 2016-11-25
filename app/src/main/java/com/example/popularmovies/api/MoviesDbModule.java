package com.example.popularmovies.api;

import com.example.popularmovies.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesDbModule {

    public Retrofit providesRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public MoviesDbApi providesMoviesDb(Retrofit retrofit) {
        return retrofit.create(MoviesDbApi.class);
    }

    public static MoviesDbApi moviesDbService() {
        MoviesDbModule module = new MoviesDbModule();
        Retrofit adapter = module.providesRetrofit();
        return module.providesMoviesDb(adapter);
    }
}
