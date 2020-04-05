package com.example.meet.test;


import android.os.Bundle;
import android.widget.Toast;

import com.example.framework.base.BaseActivity;
import com.example.framework.view.TouchPictureV;
import com.example.meet.R;

public class TestActivity extends BaseActivity {

    private TouchPictureV TouchPictureV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
    }

    private void initView() {
        TouchPictureV = (com.example.framework.view.TouchPictureV) findViewById(R.id.TouchPictureV);
        TouchPictureV.setViewResultListener(new TouchPictureV.OnViewResultListener(){
            @Override
            public void onResult(){
                Toast.makeText(TestActivity.this, "验证通过",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
