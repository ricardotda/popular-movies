package com.example.popularmovies.repositories;

public class RemoteRepositoryFactory implements RepositoryFactory {

    private static MoviesRepository remoteMovieRepository;

    @Override
    public MoviesRepository forMovies() {
        if (remoteMovieRepository == null) {
            remoteMovieRepository = new RemoteMovieRepository();
        }
        return remoteMovieRepository;
    }
}
