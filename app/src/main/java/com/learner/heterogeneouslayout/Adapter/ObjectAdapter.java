package com.learner.heterogeneouslayout.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.learner.heterogeneouslayout.Model.Flower;
import com.learner.heterogeneouslayout.Model.MarvelActor;
import com.learner.heterogeneouslayout.R;

import java.util.ArrayList;
import java.util.List;

public class ObjectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ACTOR_TYPE = 1;
    private static final int FLOWER_TYPE = 2;

    private Context context;
    private List<Object> objectList = new ArrayList<>();

    public ObjectAdapter(Context context, List<Object> objectList) {
        this.context = context;
        this.objectList = objectList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        RecyclerView.ViewHolder viewHolder = null;
        switch (i) {
            case ACTOR_TYPE:
                View view = inflater.inflate(R.layout.marvel_action_row_item, viewGroup, false);
                viewHolder = new MarvelActorHolder(view);
                break;
            case FLOWER_TYPE:
                View view2 = inflater.inflate(R.layout.flower_row_item,viewGroup,false);
                viewHolder = new FlowerHolder(view2);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case ACTOR_TYPE:
                MarvelActor actor = (MarvelActor) objectList.get(i);
                MarvelActorHolder mah = (MarvelActorHolder) viewHolder;
                mah.actorNameTextView.setText(actor.getRealname());
                mah.actorBio.setText(actor.getBio());
                Glide.with(context).load(actor.getImageurl())
                        .apply(RequestOptions.fitCenterTransform())
                        .into(mah.actorImage);
                break;
            case FLOWER_TYPE:
                Flower flower = (Flower)objectList.get(i);
                FlowerHolder flowerHolder = (FlowerHolder) viewHolder;
                flowerHolder.flowerNameTextView.setText(flower.getName());
                flowerHolder.descTextView.setText(flower.getInstructions());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }


    @Override
    public int getItemViewType(int position) {
        if (objectList.get(position) instanceof MarvelActor) {
            return ACTOR_TYPE;
        } else if (objectList.get(position) instanceof Flower){
            return FLOWER_TYPE;
        }
        return -1;
    }
}
