package com.example.olivi.ihm;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by olivi on 12/12/2018.
 */

public class DetailsProduits extends Fragment{
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            return inflater.inflate(R.layout.details_produits, container, false);
        }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AppCompatImageButton button = (AppCompatImageButton) view.findViewById(R.id.notationButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.FragmentTransaction ft;
                ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.content, new Notation());
                ft.commit();
            }
        });
    }
}
