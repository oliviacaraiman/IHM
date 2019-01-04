package com.example.olivi.ihm;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
        // on first launch : marche pas encore
        /*Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);
        if (isFirstRun) {
            startActivity(new Intent(MainActivity.this, FIrstLoad.class));
            Toast.makeText(MainActivity.this, "Run only once", Toast.LENGTH_LONG)
                    .show();
        }
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).commit();*/
        //-- on first launch

        setContentView(R.layout.activity_main);
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content, new Accueil());
        ft.commit();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


}
