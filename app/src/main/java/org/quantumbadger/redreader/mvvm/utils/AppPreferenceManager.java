package org.quantumbadger.redreader.mvvm.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class AppPreferenceManager {
    private static final String PREF_NAME = "app_pref_settings";
    private static final String KEY_HOME_SCREEN = "default_home_screen_v2";

    // Constants
    public static final int HOME = 0;
    public static final int TRENDING = 1;
    public static final int ALL_POST = 2;

    public static void setDefaultHomeScreen(Context context, Integer value) {
        SharedPreferences prefs =
                context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit().putInt(KEY_HOME_SCREEN, value).apply();
    }
    public static Integer getDefaultHomeScreen(Context context) {
        SharedPreferences prefs =
                context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        if (!prefs.contains(KEY_HOME_SCREEN)) {
            return null;
        }

        return prefs.getInt(KEY_HOME_SCREEN, HOME);
    }
}
