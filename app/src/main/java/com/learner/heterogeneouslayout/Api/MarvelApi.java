package com.learner.heterogeneouslayout.Api;

import com.learner.heterogeneouslayout.Model.MarvelActor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MarvelApi {

    @GET("marvel/")
    Call<List<MarvelActor>> getAllActor();
}
