package com.hodachop93.hohoda.utils;

import android.content.Context;

import java.util.Locale;

/**
 * Created by Hop on 07/03/2016.
 */
public class Utils {
    public static String getUserCountry(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        return locale.toString();
    }
}
