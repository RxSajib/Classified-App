package com.digital.digitalbusinessowners.Memory;

import android.content.Context;
import android.content.SharedPreferences;

import com.digital.digitalbusinessowners.DataManager;

public class SharedPref {

    private SharedPreferences sharedPreferences;

    public SharedPref(Context context){
        sharedPreferences = context.getSharedPreferences(DataManager.KeyPreserenceName, Context.MODE_PRIVATE);
    }

    public void putBoolen(String key, Boolean value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public Boolean getBoolen(String key){
        return sharedPreferences.getBoolean(key, false);
    }

    public void putString(String key, String value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key){
     return    sharedPreferences.getString(key, null);
    }

    public void clearpreference(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
