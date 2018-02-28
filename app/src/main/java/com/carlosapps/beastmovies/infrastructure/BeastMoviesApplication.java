package com.carlosapps.beastmovies.infrastructure;


import android.app.Application;

import com.carlosapps.beastmovies.live.Module;
import com.squareup.otto.Bus;

public class BeastMoviesApplication extends Application {

    private Bus bus;
    public static final String API_KEY = "ENTER YOUR OWN API KEY";
    public static final String BASE_URL = "https://api.themoviedb.org";
    public static final String BASE_PICTURE_URL = "http://image.tmdb.org/t/p/w185";

    public BeastMoviesApplication() {
        bus = new Bus();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Module.Register(this);
    }

    public Bus getBus() {
        return bus;
    }
}
