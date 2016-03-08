package com.hodachop93.hohoda.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.hodachop93.hohoda.R;
import com.hodachop93.hohoda.common.AppReferences;

public class SplashActivity extends BaseActivity {
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i;
                if (AppReferences.isUserLoggedIn()) {
                    i = HohodaActivity.getIntent(SplashActivity.this);
                } else {
                    i = SignInUpActivity.getIntent(SplashActivity.this, false);
                }
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
