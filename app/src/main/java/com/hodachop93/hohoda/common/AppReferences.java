package com.hodachop93.hohoda.common;

import android.content.Context;
import android.content.SharedPreferences;

import com.hodachop93.hohoda.HohodaApplication;

public class AppReferences {

    private static final String KEY_FIRST_LOAD = "APP_FIRST_LOAD";
    private static final String KEY_USER_WALLET_ID = "USER_WALLET_ID";
    private static final String KEY_USER_TOKEN_ID = "USER_TOKEN_ID";
    private static final String KEY_DEVICE_TOKEN = "USER_DEVICE_TOKEN";

    private static Context context = HohodaApplication.getInstance();
    private static SharedPreferences mSharedPreferences = context.getSharedPreferences("APP_REFERENCES", Context.MODE_PRIVATE);

    /**
     * Check if app is loaded for the first time
     *
     * @return true if app is first loaded, otherwise it returns false
     */
    public static boolean isAppFirstLoad() {
        boolean isAppFirstLoad = mSharedPreferences.getBoolean(KEY_FIRST_LOAD, true);
        mSharedPreferences.edit().putBoolean(KEY_FIRST_LOAD, false).apply();
        return isAppFirstLoad;
    }

    public static String getUserWalletID() {
        return mSharedPreferences.getString(KEY_USER_WALLET_ID, null);
    }

    public static void setUserWalletID(String walletID) {
        mSharedPreferences.edit().putString(KEY_USER_WALLET_ID, walletID).apply();
    }

    public static void setUserTokenID(String tokenID) {
        mSharedPreferences.edit().putString(KEY_USER_TOKEN_ID, tokenID).apply();
    }

    public static String getUserTokenID() {
        return mSharedPreferences.getString(KEY_USER_TOKEN_ID, null);
    }

    public static boolean isUserLoggedIn() {
        return getUserWalletID() != null && getUserTokenID() != null;
    }

    public static void setDeviceToken(String deviceToken) {
        mSharedPreferences.edit().putString(KEY_DEVICE_TOKEN, deviceToken).apply();
    }

    public static String getDeviceToken() {
        return mSharedPreferences.getString(KEY_DEVICE_TOKEN, null);
    }
}
