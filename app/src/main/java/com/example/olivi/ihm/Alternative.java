package com.example.olivi.ihm;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Alternative extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        String[] products = {"Lays Classic"};
        int[] values = {1};
        int[] images = {R.mipmap.lays_light};
        ItemAdapter adapter = new ItemAdapter(this.getContext(), products, values, images, this);
        View rootView = inflater.inflate(R.layout.historique, container, false);
        TextView title = rootView.findViewById(R.id.textView);
        title.setText("Alternatives");
        setListAdapter(adapter);
        return rootView;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
