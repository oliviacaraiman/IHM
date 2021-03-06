package com.example.olivi.ihm;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.TextView;

/**
 * Created by olivi on 12/10/2018.
 */

public class Favoris extends ListFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        String[] products = {"Lays Classic","Pizza 4 saisons"};
        int[] values = {1,4};
        int[] images = {R.mipmap.lays_light, R.mipmap.pizza};
        ItemAdapter adapter = new ItemAdapter(this.getContext(), products, values, images, this);
        View rootView = inflater.inflate(R.layout.historique, container, false);
/*        TextView title = rootView.findViewById(R.id.textView);
        title.setText("Favoris");*/
        setListAdapter(adapter);


        return rootView;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
