package com.lowry.baidupush;

import android.content.Context;
import android.util.Log;

import com.baidu.android.pushservice.PushMessageReceiver;

import java.util.List;

/**
 * Created by lowry on 16/4/13.
 */
public class PushReciver extends PushMessageReceiver{
    @Override
    public void onBind(Context context, int i, String s, String s1, String s2, String s3) {
        Log.i("lowry","============onBind===============");
    }

    @Override
    public void onUnbind(Context context, int i, String s) {
        Log.i("lowry","============onUnbind===============");
    }

    @Override
    public void onSetTags(Context context, int i, List<String> list, List<String> list1, String s) {
        Log.i("lowry","============onSetTags===============");

    }

    @Override
    public void onDelTags(Context context, int i, List<String> list, List<String> list1, String s) {
        Log.i("lowry","============onDelTags===============");

    }

    @Override
    public void onListTags(Context context, int i, List<String> list, String s) {
        Log.i("lowry","============onListTags===============");

    }

    @Override
    public void onMessage(Context context, String s, String s1) {
        Log.i("lowry","============onMessage===============" + s);

    }

    @Override
    public void onNotificationClicked(Context context, String s, String s1, String s2) {
        Log.i("lowry","============onNotificationClicked===============");

    }

    @Override
    public void onNotificationArrived(Context context, String s, String s1, String s2) {
        Log.i("lowry","============onNotificationArrived===============");

    }
}
