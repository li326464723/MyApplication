package com.lowry.thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ThreadMainActivity extends AppCompatActivity {
    private String Tag = "lowry";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_main);
        Mythread mt = new Mythread();
        new Thread(mt).start();
        new Thread(mt).start();
        new Thread(mt).start();
        new Thread(mt).start();
//            for (int i = 0; i < 10000000; i++) {
//                if(i == 500){
//                    try {
//                        tt.join();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                Log.i(Tag, "======当前线程==========>>" + "主线程" + i + "号" + Thread.currentThread().getName());
//            }
    }

    class Mythread implements Runnable{
        private int flag = 100;

        @Override
        public void run() {
            while(true){
                synchronized ("") {
                    if (flag > 0) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.i(Tag, "======我卖出了第==========>>" + flag-- + "张票" + Thread.currentThread().getName());
                    }
                }
            }
        }
    }
}
