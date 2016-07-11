package com.utest.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by lowry on 16/7/7.
 */
public class LoginActivity extends Activity{
    private EditText nameEdit = null;
    private EditText passEdit = null;
    private Button login = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        nameEdit = (EditText)findViewById(R.id.name_edit);
        passEdit = (EditText)findViewById(R.id.pass_edit);
        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEdit.getText().toString();
                String pass = passEdit.getText().toString();
                if((name != null && !"".equals(name)) && (pass != null && !"".equals(pass))){
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
