package com.example.olivi.ihm;

/**
 * Created by olivi on 12/10/2018.
 */
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

    public class ItemAdapter extends ArrayAdapter<String> {
        private final Context context;
        private final String[] products;
        private final int[] barValues;

        public ItemAdapter(Context context, String[] products, int[] barValues) {
            super(context, -1, products);
            this.context = context;
            this.products = products;
            this.barValues = barValues;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.historique_item, parent, false);
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
            return rowView;
        }
}
