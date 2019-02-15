package com.example.fragmentappfromscratch.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.fragmentappfromscratch.DisplayActivity;
import com.example.fragmentappfromscratch.R;
import com.example.fragmentappfromscratch.model.Planet;

public class PlanetViewHolder extends RecyclerView.ViewHolder {
    public static final String PLANET_NAME = "planet_name";
    public static final String PLANET_NUMBER = "planet_number";
    public static final String PLANET_IMAGE = "planet_image";
    private TextView planetNameTextView;

    public PlanetViewHolder(@NonNull View itemView) {
        super(itemView);
        planetNameTextView = itemView.findViewById(R.id.planet_name_textview);
    }

    public void onBind(Planet planet) {
        final String planetName = planet.getName();
        final String planetNumber = planet.getNumber();
        final String planetImage = planet.getImage();
        planetNameTextView.setText(planetName);
        planetNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString(PLANET_NAME, planetName);
                args.putString(PLANET_NUMBER, planetNumber);
                args.putString(PLANET_IMAGE, planetImage);
                Intent intent = new Intent(v.getContext(), DisplayActivity.class);
                intent.putExtras(args);
                v.getContext().startActivity(intent);
            }
        });
    }
}
