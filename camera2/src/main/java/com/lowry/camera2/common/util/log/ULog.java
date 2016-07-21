package com.lowry.camera2.common.util.log;

import android.util.Log;

/**
 * Created by lowry on 16/6/29.
 */
public class ULog {
    private static boolean DEBUG = true;
    public static void i(String Tag , String msg){
        if(DEBUG){
            Log.i(Tag,msg);
        }
    }
}
