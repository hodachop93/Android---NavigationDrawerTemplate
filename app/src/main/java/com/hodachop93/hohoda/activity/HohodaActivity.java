package com.hodachop93.hohoda.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class HohodaActivity extends BaseNavigationDrawerActivity {

    public static Intent getIntent(Context context){
        Intent intent = new Intent(context, HohodaActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
