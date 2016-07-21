package com.utest.manager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.utest.manager.R;


/**
 * Created by lowry on 16/7/12.
 */
public class DetailsActivity extends Activity{
    private ImageView leftBack = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        leftBack = (ImageView)findViewById(R.id.left_back);
        leftBack.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
