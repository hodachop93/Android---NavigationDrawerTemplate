package com.hodachop93.hohoda.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.hodachop93.hohoda.R;
import com.hodachop93.hohoda.common.ApplicationConstants;
import com.hodachop93.hohoda.fragment.FragmentNavigationDrawer;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hop on 05/03/2016.
 */
public abstract class BaseNavigationDrawerActivity extends BaseActivity implements FragmentNavigationDrawer.FragmentNavigationDrawerListener {
    @Bind(R.id.app_bar)
    Toolbar toolbar;

    private FragmentNavigationDrawer navDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hohoda);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        navDrawerFragment = (FragmentNavigationDrawer) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_navigation_drawer);
        navDrawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        navDrawerFragment.setDrawerListener(this);
    }

    @Override
    public void OnMenuItemSelected(String title, int position) {
        getSupportActionBar().setTitle(title);

        switch (position) {
            case ApplicationConstants.NavigationMenuPosition.DASHBOARD:
                switchToDashboardFragment();
                break;
            case ApplicationConstants.NavigationMenuPosition.NOTIFICATIONS:
                switchToNotificationsFragment();
                break;
        }
    }

    private void switchToDashboardFragment() {
        Toast.makeText(this, "Dashboard", Toast.LENGTH_LONG).show();
    }

    private void switchToNotificationsFragment() {
        Toast.makeText(this, "Notification", Toast.LENGTH_LONG).show();
    }
}
