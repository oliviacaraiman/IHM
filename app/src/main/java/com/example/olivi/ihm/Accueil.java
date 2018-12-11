package com.example.olivi.ihm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by olivi on 12/10/2018.
 */

public class Accueil extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("ACCUEIL", "OK");
        return inflater.inflate(R.layout.accueil, container, false);
    }
}
