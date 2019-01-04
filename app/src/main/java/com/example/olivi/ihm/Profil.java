package com.example.olivi.ihm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.*;
import android.widget.*;
import java.util.*;

public class Profil extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.profil, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        ArrayList<CheckableSpinnerItem> maladies = new ArrayList<>();
        maladies.add(new CheckableSpinnerItem("Diabète"));
        maladies.add(new CheckableSpinnerItem("Diabète", true));
        maladies.add(new CheckableSpinnerItem("Cholestérol"));
        ((Spinner)view.findViewById(R.id.spinner2)).setAdapter(new CheckableSpinnerAdapter(this.getContext(), maladies));

        ArrayList<CheckableSpinnerItem> allergies = new ArrayList<>();
        allergies.add(new CheckableSpinnerItem("Gluten"));
        allergies.add(new CheckableSpinnerItem("Gluten", true));
        allergies.add(new CheckableSpinnerItem("Fruits de mer"));
        allergies.add(new CheckableSpinnerItem("Soya"));
        allergies.add(new CheckableSpinnerItem("Graines de sésame"));
        ((Spinner)view.findViewById(R.id.spinner3)).setAdapter(new CheckableSpinnerAdapter(this.getContext(), allergies));

        ArrayList<CheckableSpinnerItem> intolerances = new ArrayList<>();
        intolerances.add(new CheckableSpinnerItem("Lactose, arachides"));
        intolerances.add(new CheckableSpinnerItem("Lactose", true));
        intolerances.add(new CheckableSpinnerItem("Arachides", true));
        intolerances.add(new CheckableSpinnerItem("Fruits à coques"));
        ((Spinner)view.findViewById(R.id.spinner4)).setAdapter(new CheckableSpinnerAdapter(this.getContext(), intolerances));

        final EditText editIngredientIndesirable = view.findViewById(R.id.editIngredientIndesirable);

        editIngredientIndesirable.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    if(editIngredientIndesirable.getText().length() > 0) {
                        ajouterIngredientIndesirable(editIngredientIndesirable.getText().toString());
                        editIngredientIndesirable.setText("");
                    }
                    return true;
                }
                return false;
            }
        });

        ajouterIngredientIndesirable("Noix");
        ajouterIngredientIndesirable("Choux");
    }

    private void ajouterIngredientIndesirable(String name) {
        final LinearLayout layout = getView().findViewById(R.id.ingredients_indesirables);

        final View pillItem = getLayoutInflater().inflate(R.layout.pill_item, null);
        ((TextView)pillItem.findViewById(R.id.pillName)).setText(name);

        pillItem.findViewById(R.id.closeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.removeView(pillItem);
            }
        });

        layout.addView(pillItem, layout.getChildCount() - 1);
    }
}
