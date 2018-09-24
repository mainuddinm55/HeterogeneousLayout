package com.learner.heterogeneouslayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.learner.heterogeneouslayout.Adapter.ObjectAdapter;
import com.learner.heterogeneouslayout.Api.FlowerApi;
import com.learner.heterogeneouslayout.Api.MarvelApi;
import com.learner.heterogeneouslayout.Model.Flower;
import com.learner.heterogeneouslayout.Model.MarvelActor;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private List<Object> mObjectList = new ArrayList<>();
    private RecyclerView mObjectRecyclerView;
    private ObjectAdapter mObjectAdapter;

    public static final String MARVEL_BASE_URL = "https://simplifiedcoding.net/demos/";
    public static final String FLOWER_BASE_URL = "http://services.hanselandpetal.com/feeds/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mObjectRecyclerView = findViewById(R.id.object_list);
        mObjectRecyclerView.setHasFixedSize(true);
        mObjectRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        getAllActors();


    }


    private void getAllActors() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(MARVEL_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MarvelApi api = retrofit.create(MarvelApi.class);

        Call<List<MarvelActor>> call = api.getAllActor();

        call.enqueue(new Callback<List<MarvelActor>>() {
            @Override
            public void onResponse(Call<List<MarvelActor>> call, Response<List<MarvelActor>> response) {
                List<MarvelActor> marvelActorList = response.body();
                mObjectList.addAll(marvelActorList);
                mObjectAdapter = new ObjectAdapter(MainActivity.this, mObjectList);
                mObjectRecyclerView.setAdapter(mObjectAdapter);
                getFlowers();
            }

            @Override
            public void onFailure(Call<List<MarvelActor>> call, Throwable t) {

            }
        });

    }

    private void getFlowers() {
        Retrofit flowerRetrofit = new Retrofit.Builder()
                .baseUrl(FLOWER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FlowerApi flowerApi = flowerRetrofit.create(FlowerApi.class);

        Call<List<Flower>> flowerCall = flowerApi.getAllFlower();

        flowerCall.enqueue(new Callback<List<Flower>>() {
            @Override
            public void onResponse(Call<List<Flower>> call, Response<List<Flower>> response) {
                List<Flower> flowerList = response.body();
                mObjectList.addAll(flowerList);
                mObjectAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Flower>> call, Throwable t) {

            }
        });
    }

}
