package com.carlosapps.beastmovies.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.carlosapps.beastmovies.R;
import com.carlosapps.beastmovies.entites.Movie;
import com.carlosapps.beastmovies.services.MovieServices;
import com.squareup.otto.Subscribe;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {
    @BindView(R.id.activity_main_progressBar)
    ProgressBar progressBar;

    @BindView(R.id.activity_main_movie_summary)
    TextView movieSummary;

    @BindView(R.id.activity_main_movie_vote)
    TextView movieVote;

    @BindView(R.id.activity_main_moviePicture)
    ImageView moviePicture;

    @BindView(R.id.activity_main_movieReleaseDate)
    TextView movieReleaseDate;

    @BindView(R.id.activity_main_movieTitle)
    TextView movieTitle;

    @BindView(R.id.activity_main_right_arrow)
    ImageView rightArrow;

    @BindView(R.id.activity_main_left_arrow)
    ImageView leftArrow;

    ArrayList<Movie> movies;

    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        movies = new ArrayList<>();
        index =0;
        bus.post(new MovieServices.SearchMoviesRequest("popular"));

        if (movies.size()!=0){
            UpdateUI(movies.get(index));
        }

    }


    private void UpdateUI(Movie movie){
        progressBar.setVisibility(View.VISIBLE);
        movieTitle.setText(movie.getMovieTitle());
        movieSummary.setText(movie.getMovieSummary());
        movieReleaseDate.setText(movie.getMovieReleaseDate());
        movieVote.setText(Double.toString(movie.getMovieRating()));


        Picasso.with(this).load(movie.getMoviePicture())
                .fit()
                .centerCrop()
                .into(moviePicture, new Callback() {
                    @Override
                    public void onSuccess() {
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });


    }

    @OnClick(R.id.activity_main_left_arrow)
    public void setUpLeftArrow(){
        if (index == 0){
            Toast.makeText(this,"This is the start of the movies!",Toast.LENGTH_SHORT).show();
        } else{
            index --;
            UpdateUI(movies.get(index));
        }

    }

    @OnClick(R.id.activity_main_right_arrow)
    public void setUpRightArrow(){
        if (index == movies.size()-1){
            Toast.makeText(this,"This is the end of the movies!",Toast.LENGTH_SHORT).show();
        } else{
            index ++;
            UpdateUI(movies.get(index));
        }
    }


    @Subscribe
    public void getMovieMessage(MovieServices.SearchMoviesResponse response){
        movies.clear();
        movies.addAll(response.movies);
    }
}
