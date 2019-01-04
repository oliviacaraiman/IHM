package com.example.olivi.ihm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

/**
 * Created by olivi on 12/10/2018.
 */

public class Accueil extends Fragment {

    private Button button = null;
    private Button buttonConsulterDetails = null;
    private ImageButton buttonRetour = null;
    private RelativeLayout layout = null;
    private RelativeLayout layout2 = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("ACCUEIL", "OK");
        return inflater.inflate(R.layout.accueil, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button = (Button) view.findViewById(R.id.button2);
        buttonConsulterDetails = (Button) view.findViewById(R.id.button);
        buttonRetour = (ImageButton) view.findViewById(R.id.imageButton4);
        layout = (RelativeLayout)  view.findViewById(R.id.relativeHidden);
        layout2 = (RelativeLayout)  view.findViewById(R.id.relativeHidden2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setVisibility(View.VISIBLE);
                layout2.setVisibility(View.GONE);
            }
        });
        buttonConsulterDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.FragmentTransaction ft;
                ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.content, new DetailsProduits());
                ft.commit();
            }
        });
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout2.setVisibility(View.VISIBLE);
                layout.setVisibility(View.GONE);
            }
        });

    }
}
