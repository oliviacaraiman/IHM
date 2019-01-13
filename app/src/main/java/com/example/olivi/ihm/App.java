package com.example.olivi.ihm;

import android.app.Application;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("/assets/pacifico.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        FontsOverride.setDefaultFont(this, "DEFAULT", "Roboto-Regular.ttf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "Roboto-Regular.ttf");
        FontsOverride.setDefaultFont(this, "SERIF", "Roboto-Regular.ttf");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "Roboto-Regular.ttf");
    }
}
