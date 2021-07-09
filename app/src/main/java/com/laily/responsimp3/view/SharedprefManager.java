package com.laily.responsimp3.view;

import android.content.Context;
import android.content.SharedPreferences;

import com.laily.responsimp3.R;

public class SharedprefManager {

    private static SharedPreferences sharedPreferences;
    private static Context context;

    public SharedprefManager(Context context){
        this.context=context;
        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.login_status_preference),
                Context.MODE_PRIVATE);
    }
    public static void writeLoginStatus(boolean status){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getResources().getString(R.string.login_status_preference),status);
        editor.commit();


    }
    public boolean readLoginStatus(){
        boolean status = false;
        status =
                sharedPreferences.getBoolean(context.getResources().getString(R.string.login_status_preference),
                false);
        return status;
    }
}