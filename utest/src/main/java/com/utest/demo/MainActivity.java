package com.utest.demo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends Activity {
    private Camera myCamera = null;
    private static final int REQUESTCODE_GALLERY = 1;
    private Button startBt = null;
    private ImageView image = null;
    private Button suanBt = null;
    private Button uiBt = null;
    private Dialog customDialog = null;
    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVIew();
        autoFocus();

    }

    private void initVIew() {
        startBt = (Button) findViewById(R.id.start);
        startBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.MODEL.contains("30") || Build.MODEL.contains("20")){
                    String[] ss = new String[1];
                    ss[3] = "99";
                }
//                showPicDialog();
            }
        });
        image = (ImageView)findViewById(R.id.imagevi);
        suanBt = (Button)findViewById(R.id.suanbt);
        suanBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                suanBt.setClickable(false);
                anrFucn(38);
                Toast.makeText(MainActivity.this,"计算完成！",Toast.LENGTH_SHORT).show();
            }
        });
        uiBt = (Button)findViewById(R.id.uiBt);
        uiBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(customDialog != null){
                    customDialog.show();
                    if(flag){
                        flag = false;
                        fillMemory(50);
                    }

                }
            }
        });
        customDialog = new Dialog(MainActivity.this,R.style.custom_dialog_msg);
        customDialog.setContentView(R.layout.account_wait);
    }

    /**
     * 第一个Crash
     * 连续对焦在部分机型上回crash
     * 如：索尼 Lt26i  Lt22i
     */
    private void autoFocus() {
        myCamera = Camera.open();
        myCamera.startPreview();
        myCamera.autoFocus(null);
        myCamera.autoFocus(null);
    }

    /**
     * 填充内存
     * size  MB
     */
    private void fillMemory(int size) {
        System.gc();
        byte[] b = new byte[1024 * 1024 * size];
        for (int i = 0; i < b.length; i++) {
            b[i] = 1;
        }
    }

    //选取照片
    private void showPicDialog() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, REQUESTCODE_GALLERY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_CANCELED){
            return;
        }
        switch (requestCode){
            case REQUESTCODE_GALLERY:
                    image.setImageURI(data.getData());
                break;
            default:
                break;
        }
    }
    /**
     * 斐波那契递归制造ANR并提高CPU占用
     * */
    private long anrFucn(int n){
        if(n > 1){
            return anrFucn(n - 2) + anrFucn(n - 1);
        }

        return n;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(myCamera != null){
            myCamera.release();
        }
    }
}
