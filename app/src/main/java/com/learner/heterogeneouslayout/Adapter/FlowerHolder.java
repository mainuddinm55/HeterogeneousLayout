package com.learner.heterogeneouslayout.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.learner.heterogeneouslayout.R;

public class FlowerHolder extends RecyclerView.ViewHolder {

    public TextView flowerNameTextView;
    public TextView descTextView;
    public FlowerHolder(@NonNull View itemView) {
        super(itemView);
        flowerNameTextView = itemView.findViewById(R.id.flower_name);
        descTextView = itemView.findViewById(R.id.instruction);
    }
}
