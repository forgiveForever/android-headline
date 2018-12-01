package com.androidgroup;

import android.app.Application;
import android.content.Context;

/**
 * Created by silence on 2018/10/14.
 */

public class MyApplication extends Application {
    private static Context context;
    public void onCreate(){
        super.onCreate();
        context=getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }
}
