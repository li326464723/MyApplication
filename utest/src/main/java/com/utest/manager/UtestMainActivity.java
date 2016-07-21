package com.utest.manager;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.utest.manager.R;

/**
 * Created by lowry on 16/7/11.
 */
public class UtestMainActivity extends FragmentActivity {
    /**
     * FragmentTabhost
     */
    private FragmentTabHost mTabHost;
    private LayoutInflater mLayoutInflater;
    private Class mFragmentArray[] = { AutoFragment.class, PhoneFragment.class,
            ZnoeFragment.class };
    private int mImageArray[] = { R.drawable.tab_more_btn,
            R.drawable.tab_more_btn, R.drawable.tab_more_btn};
    private String mTextArray[] = {"自动化","云手机","优社区"};
    private ImageView head = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utest_main);

        initView();
    }

    /**
     * 初始化组件
     *
     * **/
    private void initView() {
        mLayoutInflater = LayoutInflater.from(this);

        mTabHost = (FragmentTabHost) findViewById(R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        // 得到fragment个数
        int count = mFragmentArray.length;
        for (int i = 0; i < count; i++) {
            // 给每个tab设置图标和内容
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTextArray[i])
                    .setIndicator(getTabItemView(i));
            //将Tab加到Tab选项卡中
            mTabHost.addTab(tabSpec, mFragmentArray[i], null);
//            //设置Tab背景
//            mTabHost.getTabWidget().getChildAt(i)
//                    .setBackgroundResource(R.drawable.selector_tab_background);
        }
        head = (ImageView)findViewById(R.id.head);
        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UtestMainActivity.this,SettingActivity.class);
                startActivity(intent);
            }
        });
    }

    /*
     *设置Tab按钮的图标和文字
     */
    private View getTabItemView(int index) {
        View view = mLayoutInflater.inflate(R.layout.tab_item_view, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        imageView.setImageResource(mImageArray[index]);
        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText(mTextArray[index]);
        return view;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if(event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_BACK){
            exit();
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    private void exit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("确定要退出？").setTitle("提示").setNegativeButton("取消",null).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
