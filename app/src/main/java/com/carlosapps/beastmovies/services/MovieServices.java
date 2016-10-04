package com.carlosapps.beastmovies.services;

import com.carlosapps.beastmovies.entites.Movie;

import java.util.ArrayList;

public class MovieServices {
    private MovieServices() {
    }

    public static class SearchMoviesRequest{
        public String query;

        public SearchMoviesRequest(String query) {
            this.query = query;
        }
    }

    public static class SearchMoviesResponse{
        public ArrayList<Movie> movies;
    }
}
