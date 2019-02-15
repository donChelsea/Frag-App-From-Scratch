package com.example.fragmentappfromscratch.frags;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragmentappfromscratch.R;
import com.squareup.picasso.Picasso;

import static com.example.fragmentappfromscratch.view.PlanetViewHolder.PLANET_IMAGE;
import static com.example.fragmentappfromscratch.view.PlanetViewHolder.PLANET_NAME;
import static com.example.fragmentappfromscratch.view.PlanetViewHolder.PLANET_NUMBER;

public class DisplayFragment extends Fragment {
    private View rootView;
    private TextView planetNameTextView;
    private TextView planetNumberTextView;
    private ImageView planetImageView;


    public DisplayFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_display, container, false);

        Bundle args = getArguments();
        assert args != null;
        String planetName = args.getString(PLANET_NAME);
        String planetNumber = args.getString(PLANET_NUMBER);
        String planetImage = args.getString(PLANET_IMAGE);

        planetNameTextView = rootView.findViewById(R.id.display_planet_name);
        planetNumberTextView = rootView.findViewById(R.id.planet_number);
        planetImageView = rootView.findViewById(R.id.planet_image);

        planetNameTextView.setText(planetName);
        planetNumberTextView.setText(planetNumber);

        Picasso.get()
                .load(planetImage)
                .into(planetImageView);

        return inflater.inflate(R.layout.fragment_display, container, false);
    }

}
