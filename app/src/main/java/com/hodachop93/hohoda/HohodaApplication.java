package com.hodachop93.hohoda;

import android.app.Application;

/**
 * Created by Hop on 03/03/2016.
 */
public class HohodaApplication extends Application {
    private static HohodaApplication instance;

    public static HohodaApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
