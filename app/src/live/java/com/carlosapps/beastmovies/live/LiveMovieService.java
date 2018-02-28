package com.carlosapps.beastmovies.live;


import com.carlosapps.beastmovies.entites.Movie;
import com.carlosapps.beastmovies.infrastructure.BeastMoviesApplication;
import com.carlosapps.beastmovies.model.MovieModel;
import com.carlosapps.beastmovies.model.ParentModel;
import com.carlosapps.beastmovies.services.MovieServices;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LiveMovieService extends BaseLiveService {


    public LiveMovieService(BeastMoviesApplication application, MovieWebServices api) {
        super(application, api);
    }

    @Subscribe
    public void getMovieMessage(final MovieServices.SearchMoviesRequest request) {
        final MovieServices.SearchMoviesResponse Movieresponse = new MovieServices.SearchMoviesResponse();
        Movieresponse.movies = new ArrayList<>();
        Call<ParentModel> call = api.loadMovies(request.query, BeastMoviesApplication.API_KEY);
        call.enqueue(new Callback<ParentModel>() {
            @Override
            public void onResponse(Call<ParentModel> call, Response<ParentModel> response) {
                ParentModel parentModel = response.body();
                if (parentModel != null) {
                    for (MovieModel movieModel : parentModel.movieInfos) {
                        Movieresponse.movies.add(new Movie(movieModel.getMovieTitle(),
                                movieModel.getMovieSummary(), BeastMoviesApplication.BASE_PICTURE_URL + movieModel.getMoviePoster(),
                                movieModel.getMovieRelaseDate(), movieModel.getMovieAverage()));
                    }
                }
                bus.post(Movieresponse);
            }

            @Override
            public void onFailure(Call<ParentModel> call, Throwable t) {

            }
        });
    }

}
