package com.example.maike.flaborfit;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Henk-Martijn Leidelmeijer on 2018-03-22.
 */

public class SharedPrefs {

    public static boolean getBoolean(Context context, String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

        if (preferences != null) {
            // als de key (nog) niet bestaat, wordt er standaard false gereturned (de checkbox is dan unchecked)
            return  preferences.getBoolean(key, false);
        }

        return false;
    }

    public static void setBoolean(Context context, String key, boolean value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (preferences != null) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(key, value);
            editor.apply();
        }
    }
}
