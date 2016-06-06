package com.example.lowry.viewpagerdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ViewPagerMainActivity extends AppCompatActivity {
    private ViewPager pager = null;
    private PagerTabStrip tabStrip = null;
    private ArrayList<View> viewArrayList = new ArrayList<View>();
    private ArrayList<String> titleArrayList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        pager = (ViewPager)findViewById(R.id.viewpager);
        tabStrip = (PagerTabStrip)findViewById(R.id.tabstrip);
//        tabStrip.setDrawFullUnderline(false);//取消下划线
        tabStrip.setBackgroundColor(this.getResources().getColor(R.color.bg));//设置tab背景色
        tabStrip.setTabIndicatorColor(this.getResources().getColor(R.color.red));//设置当前tab的下划线颜色
        tabStrip.setTextSpacing(200);

        View view1 = LayoutInflater.from(this).inflate(R.layout.tab1,null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.tab2,null);
        View view3 = LayoutInflater.from(this).inflate(R.layout.tab3,null);
        View view4 = LayoutInflater.from(this).inflate(R.layout.tab4,null);

        viewArrayList.add(view1);
        viewArrayList.add(view2);
        viewArrayList.add(view3);
        viewArrayList.add(view4);

        titleArrayList.add("Tab1");
        titleArrayList.add("Tab2");
        titleArrayList.add("Tab3");
        titleArrayList.add("Tab4");

        pager.setAdapter(new PagerAdapter() {
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                //销毁当前的View
                ((ViewPager)container).removeView(viewArrayList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                //滑动时生成的组件
                ((ViewPager)container).addView(viewArrayList.get(position));
                return viewArrayList.get(position);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titleArrayList.get(position);
            }

            @Override
            public int getCount() {
                return viewArrayList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_pager_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
