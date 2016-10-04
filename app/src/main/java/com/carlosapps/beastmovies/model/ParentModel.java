package com.carlosapps.beastmovies.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ParentModel {
    @SerializedName("results")
    public List<MovieModel> movieInfos;
}
