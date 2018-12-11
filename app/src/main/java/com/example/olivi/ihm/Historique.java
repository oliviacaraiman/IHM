package com.example.olivi.ihm;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Historique extends ListFragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        String[] products = {"Lays Classic","Pizza 4 saisons","Houmous Carrefour"};
        int[] values = {25,90,50};
        ItemAdapter adapter = new ItemAdapter(this.getContext(), products, values);
        View rootView = inflater.inflate(R.layout.historique, container, false);
        TextView title = rootView.findViewById(R.id.textView);
        title.setText("Historique");
        setListAdapter(adapter);
        return rootView;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
