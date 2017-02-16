package com.lowry.viewgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by lowry on 2017/2/9.
 */

public class TestButton extends android.support.v7.widget.AppCompatButton{

    public TestButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i("lowry","-----dispatchTouchEvent---" + event.getAction());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("lowry","-----onTouchEvent---" + event.getAction());
        return super.onTouchEvent(event);
    }
}
