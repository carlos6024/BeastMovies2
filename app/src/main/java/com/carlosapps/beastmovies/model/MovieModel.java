package com.carlosapps.beastmovies.model;

import com.google.gson.annotations.SerializedName;

public class MovieModel {
    @SerializedName("poster_path")
    String moviePoster;

    @SerializedName("vote_average")
    double movieAverage;

    @SerializedName("title")
    String movieTitle;

    @SerializedName("overview")
    String movieSummary;


    @SerializedName("release_date")
    String movieRelaseDate;


    public MovieModel() {
    }

    public String getMoviePoster() {
        return moviePoster;
    }


    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieSummary() {
        return movieSummary;
    }

    public String getMovieRelaseDate() {
        return movieRelaseDate;
    }

    public double getMovieAverage() {
        return movieAverage;
    }
}
