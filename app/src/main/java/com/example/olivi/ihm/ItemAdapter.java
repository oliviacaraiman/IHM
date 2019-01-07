package com.example.olivi.ihm;

/**
 * Created by olivi on 12/10/2018.
 */
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
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
        private final int[] images;
        private final Fragment fragment;

        public ItemAdapter(Context context, String[] products, int[] barValues, int[] images, Fragment fr) {
            super(context, -1, products);
            this.context = context;
            this.products = products;
            this.barValues = barValues;
            this.images = images;
            this.fragment = fr;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View rowView = inflater.inflate(R.layout.historique_item, parent, false);
            TextView textView = (TextView) rowView.findViewById(R.id.label);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
            ProgressBar progressBar = rowView.findViewById(R.id.progressBar);
            textView.setText(products[position]);
            textView.setTextSize(16);
            imageView.setImageResource(images[position]);
            progressBar.setProgress(barValues[position]);
            progressBar.setMax(5);

            if (barValues[position] < 3) {
                progressBar.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#c3212c")));
                progressBar.setProgressBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#c3212c")));
            } else if ((barValues[position] < 4) && (barValues[position] >=3)) {
                progressBar.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#FFE9C563")));
                progressBar.setProgressBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFE9C563")));
            }
            else {
                progressBar.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#FF8AAC2D")));
                progressBar.setProgressBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FF8AAC2D")));
            }

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
