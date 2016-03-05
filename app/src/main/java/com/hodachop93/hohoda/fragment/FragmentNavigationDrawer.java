package com.hodachop93.hohoda.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hodachop93.hohoda.R;
import com.hodachop93.hohoda.adapter.NavigationDrawerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hop on 04/03/2016.
 */
public class FragmentNavigationDrawer extends Fragment implements AdapterView.OnItemClickListener {
    @Bind(R.id.drawer_list)
    ListView drawerList;

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private NavigationDrawerAdapter mNavDrawerAdapter;
    private View containerView;

    private FragmentNavigationDrawerListener mDrawerListener;

    public FragmentNavigationDrawer() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflating view layout
        View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        ButterKnife.bind(this, layout);
        mNavDrawerAdapter = new NavigationDrawerAdapter(getActivity());
        drawerList.setAdapter(mNavDrawerAdapter);
        drawerList.setOnItemClickListener(this);


        return layout;
    }

    //Set up navigation drawer layout
    public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar) {
        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                toolbar.setAlpha(1 - slideOffset / 2);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }

    //When click on a navigation drawer menu item
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (mDrawerListener != null) {
            mDrawerLayout.closeDrawer(containerView);
            mDrawerListener.OnMenuItemSelected(mNavDrawerAdapter.getTitleSelectedItem(position),position);
        }
    }

    public void setDrawerListener(FragmentNavigationDrawerListener listener) {
        this.mDrawerListener = listener;
    }

    public interface FragmentNavigationDrawerListener {
        public void OnMenuItemSelected(String title, int position);
    }

}
