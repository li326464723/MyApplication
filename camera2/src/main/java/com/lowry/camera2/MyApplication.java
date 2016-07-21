package com.lowry.camera2;

import android.app.Application;
import android.content.Context;

/**
 * Created by lowry on 16/6/29.
 */
public class MyApplication extends Application {
    public static Context MY_APPLICATION_CONTEXT = null;

    @Override
    public void onCreate() {
        super.onCreate();
        MY_APPLICATION_CONTEXT = getApplicationContext();
    }
}
