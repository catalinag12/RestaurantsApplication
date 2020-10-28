package com.example.restaurantsapplication.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefUtil {
    public static final String SHARED_PREFS="sharedPreferences";

    private SharedPrefUtil(){
    }


    static public int getRestaurantId(Context context, String key) {
        return  context.getSharedPreferences(SHARED_PREFS,Context.MODE_PRIVATE).getInt(key,0);
    }

    static public void saveData(Context context, String key, int val){
        context.getSharedPreferences(SHARED_PREFS,Context.MODE_PRIVATE).edit().putInt(key,val).apply();
    }

    static public SharedPreferences.Editor getSharedPrefEditor(Context context, String pref){
        return context.getSharedPreferences(pref,Context.MODE_PRIVATE).edit();
    }

    static public void saveData(SharedPreferences.Editor editor){
        editor.apply();
    }
}
