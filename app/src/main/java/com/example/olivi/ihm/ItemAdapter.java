package com.example.olivi.ihm;

/**
 * Created by olivi on 12/10/2018.
 */
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

    public class ItemAdapter extends ArrayAdapter<String> {
        private final Context context;
        private final String[] products;
        private final int[] barValues;
        private final Fragment fragment;


        public ItemAdapter(Context context, String[] products, int[] barValues, Fragment fr) {
            super(context, -1, products);
            this.context = context;
            this.products = products;
            this.barValues = barValues;
            this.fragment = fr;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View rowView = inflater.inflate(R.layout.historique_item, parent, false);
            TextView textView = (TextView) rowView.findViewById(R.id.label);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
            ProgressBar progressBar = rowView.findViewById(R.id.progressBar);
            textView.setText(products[position]);
            imageView.setImageResource(R.drawable.ic_dashboard_black_24dp);
            progressBar.setProgress(barValues[position]);

            if (barValues[position] <= 30) {
                progressBar.setProgressTintList(ColorStateList.valueOf(Color.RED));
            } else if ((barValues[position] < 60) && (barValues[position] > 30))
                progressBar.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
            else progressBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN));

            Button button = (Button)rowView.findViewById(R.id.buttonDetails);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    android.support.v4.app.FragmentTransaction ft;
                    ft = fragment.getActivity().getSupportFragmentManager().beginTransaction();
                    Fragment details = new DetailsProduits();
                    ft.replace(R.id.content, details);
                    ft.commit();
                }
            });
            return rowView;
        }

}
