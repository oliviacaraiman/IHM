package com.example.olivi.ihm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

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

        Spinner spinner = (Spinner)view.findViewById(R.id.spinner);
        //Création d'une liste d'élément à mettre dans le Spinner(pour l'exemple)
        List defautsList = new ArrayList();
        defautsList.add("2 additifs");
        defautsList.add("E215");
        defautsList.add("E110");

        ArrayAdapter adapter = new ArrayAdapter(this.getContext(),android.R.layout.simple_spinner_item,defautsList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        final ToggleButton toggle = (ToggleButton) view.findViewById(R.id.button_favorite);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggle.setBackgroundDrawable(ContextCompat.getDrawable(getContext(),R.drawable.gold_star));
                } else {
                    toggle.setBackgroundDrawable(ContextCompat.getDrawable(getContext(),R.drawable.grey_star));
                }
            }
        });
    }
}
