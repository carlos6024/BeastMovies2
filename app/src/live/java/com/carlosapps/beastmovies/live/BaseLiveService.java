package com.carlosapps.beastmovies.live;

import com.carlosapps.beastmovies.infrastructure.BeastMoviesApplication;
import com.squareup.otto.Bus;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseLiveService {
    protected BeastMoviesApplication application;
    protected Bus bus;
    protected MovieWebServices api;

    public BaseLiveService(BeastMoviesApplication application,MovieWebServices api) {
        this.application = application;
        this.api = api;
        bus = application.getBus();
        bus.register(this);
    }
}
