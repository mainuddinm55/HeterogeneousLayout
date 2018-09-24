package com.learner.heterogeneouslayout.Api;

import com.learner.heterogeneouslayout.Model.Flower;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FlowerApi {

    @GET("flowers.json")
    Call<List<Flower>> getAllFlower();
}
