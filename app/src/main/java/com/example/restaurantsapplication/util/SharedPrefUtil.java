package com.example.restaurantsapplication.util;

import android.content.Context;
import android.content.SharedPreferences;


public class SharedPrefUtil {
    public static final String SHARED_PREFS="sharedPreferences";

    private SharedPrefUtil(){
        super();
    }


    public static void addOrRemoveItem(Context context, int id){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(sharedPreferences.contains(id+"")){
            editor.remove(""+id);
        }else{
            editor.putInt(""+id, id);
        }
        editor.apply();
    }


    public  static boolean isFavourite(Context context, int id){

        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        if(sharedPreferences.contains(id+"")){
           return true;
        }
        return false;
    }

}
