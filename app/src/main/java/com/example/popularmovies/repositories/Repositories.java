package com.example.popularmovies.repositories;

public class Repositories {

    /** no instances **/
    private Repositories() {}

    public static RepositoryFactory repository() {
        return new RemoteRepositoryFactory();
    }
}
