package com.example.olivi.ihm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private android.support.v4.app.FragmentTransaction ft;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_accueil:
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.content, new Accueil());
                    ft.commit();
                    return true;
                case R.id.navigation_profil:
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.content, new Profil());
                    ft.commit();
                    return true;
                case R.id.navigation_historique:
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.content, new Historique());
                    ft.commit();
                    return true;
                case R.id.navigation_favoris:
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.content, new Favoris());
                    ft.commit();
                    return true;
            }
            return false;

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
