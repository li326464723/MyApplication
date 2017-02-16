package com.lowry.viewgroup;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by lowry on 2017/2/10.
 */

public class TestLinearLayout extends LinearLayout {
    public TestLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i("lowry","-----TestLinearLayout------onInterceptTouchEvent--" + ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("lowry","-----TestLinearLayout------dispatchTouchEvent--" + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("lowry","-----TestLinearLayout------onTouchEvent--" + event.getAction());
        return super.onTouchEvent(event);
    }
}
