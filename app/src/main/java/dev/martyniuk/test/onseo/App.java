package dev.martyniuk.test.onseo;

import android.app.Application;

import dev.martyniuk.test.onseo.layer.gateway.assets.main.GatewayAssetsDefault;

public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        try {
            new GatewayAssetsDefault(getAssets()).updateEvents();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
