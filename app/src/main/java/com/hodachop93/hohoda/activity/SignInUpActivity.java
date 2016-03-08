package com.hodachop93.hohoda.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.hodachop93.hohoda.R;
import com.hodachop93.hohoda.adapter.SignInUpPagerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Hop on 05/03/2016.
 */
public class SignInUpActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.view_pager)
    ViewPager viewPager;

    private SignInUpPagerAdapter mAdapter;

    /**
     * get sign in or sign up intent
     *
     * @param context      current context
     * @param showRegister true if it is register fragment
     * @return the intent
     */
    public static Intent getIntent(Context context, boolean showRegister) {
        Intent intent = new Intent(context, SignInUpActivity.class);
        intent.putExtra("SHOW_REGISTER", showRegister);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_up);
        ButterKnife.bind(this);


        mAdapter = new SignInUpPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mAdapter);
        viewPager.addOnPageChangeListener(this);
        tabLayout.setupWithViewPager(viewPager);
        //TODO: custom tab layout
        tabLayout.getTabAt(0).setCustomView(R.layout.layout_custom_tablayout);
        tabLayout.getTabAt(1).setCustomView(R.layout.layout_custom_tablayout);
        invalidateTabIndicator();
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        invalidateTabIndicator();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void invalidateTabIndicator() {
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).getCustomView().findViewById(R.id.tab_indicator)
                    .setVisibility(i == viewPager.getCurrentItem() ? View.VISIBLE : View.INVISIBLE);
            tabLayout.getTabAt(i).getCustomView().setSelected(i == viewPager.getCurrentItem());
        }
    }
}
