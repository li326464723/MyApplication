package com.example.lowry.myapplication;

import android.os.Looper;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LogCatMainActivity extends AppCompatActivity implements Runnable{
    private TextView msg = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_cat_main);
        init();
    }

    private void init() {
        msg = (TextView)findViewById(R.id.msg);
        new Thread(LogCatMainActivity.this).start();
    }

    @Override
    public void run() {
        try {
            java.lang.Process process = Runtime.getRuntime().exec("logcat");
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuffer log = new StringBuffer();
            String line;
            while((line = bufferReader.readLine()) != null){
//                log.append(line);
//                Looper.prepare();
                msg.append(line + "\n");
//                Looper.loop();

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
