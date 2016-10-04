package com.carlosapps.beastmovies.live;


import com.carlosapps.beastmovies.infrastructure.BeastMoviesApplication;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Module {

    public static void Register(BeastMoviesApplication application){
        new LiveMovieService(application,createMovieService());
    }


    private static MovieWebServices createMovieService(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BeastMoviesApplication.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(MovieWebServices.class);


    }
}


