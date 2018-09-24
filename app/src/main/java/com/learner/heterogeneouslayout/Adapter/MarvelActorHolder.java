package com.learner.heterogeneouslayout.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.learner.heterogeneouslayout.R;


public class MarvelActorHolder extends RecyclerView.ViewHolder {

    public TextView actorNameTextView;
    public ImageView actorImage;
    public TextView actorBio;

    public MarvelActorHolder(@NonNull View itemView) {
        super(itemView);
        actorBio = itemView.findViewById(R.id.actor_bio);
        actorImage = itemView.findViewById(R.id.actor_image);
        actorNameTextView = itemView.findViewById(R.id.actor_name);
    }
}
