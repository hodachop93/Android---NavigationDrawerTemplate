package com.hodachop93.hohoda.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;

import com.hodachop93.hohoda.fragment.SignInFragment;
import com.hodachop93.hohoda.fragment.SignUpFragment;

/**
 * Created by Hop on 05/03/2016.
 */
public class SignInUpPagerAdapter extends FragmentStatePagerAdapter {

    public SignInUpPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return SignInFragment.newInstance();
            case 1:
                return SignUpFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Sign In";
            case 1:
                return "Sign Up";
            default:
                return null;
        }
    }
}
