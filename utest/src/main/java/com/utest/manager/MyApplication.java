package com.utest.manager;

import android.app.Application;
import android.content.Context;

/**
 * Created by lowry on 16/7/12.
 */
public class MyApplication extends Application {
    public static Context APPLICATION_CONTEXT;

    @Override
    public void onCreate() {
        super.onCreate();
        APPLICATION_CONTEXT = getApplicationContext();
    }
}
