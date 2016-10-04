package com.carlosapps.beastmovies.entites;

public class Movie {

    private String movieTitle;
    private String movieSummary;
    private String moviePicture;
    private String movieReleaseDate;
    private double movieRating;

    public Movie(String movieTitle, String movieSummary, String moviePicture, String movieReleaseDate, double movieRating) {
        this.movieTitle = movieTitle;
        this.movieSummary = movieSummary;
        this.moviePicture = moviePicture;
        this.movieReleaseDate = movieReleaseDate;
        this.movieRating = movieRating;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieSummary() {
        return movieSummary;
    }

    public String getMoviePicture() {
        return moviePicture;
    }

    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public double getMovieRating() {
        return movieRating;
    }
}
