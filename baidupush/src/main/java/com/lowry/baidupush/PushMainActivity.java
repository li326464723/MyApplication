package com.lowry.baidupush;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;

public class PushMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_main);
        PushManager.startWork(getApplicationContext(), PushConstants.LOGIN_TYPE_API_KEY,"7kLPCMEA8Z3X6envaQc0Dpk8");
    }
}
