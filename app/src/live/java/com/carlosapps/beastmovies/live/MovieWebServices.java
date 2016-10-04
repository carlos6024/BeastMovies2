package com.carlosapps.beastmovies.live;

import com.carlosapps.beastmovies.model.ParentModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieWebServices {

    @GET("/3/movie/{parameter}")
    Call<ParentModel> loadMovies(
            @Path("parameter") String requestType,
            @Query("api_key") String APIKEY
    );

}
