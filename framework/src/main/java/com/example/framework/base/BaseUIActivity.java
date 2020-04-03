package com.example.framework.base;

import android.os.Bundle;


import com.example.framework.utils.SystemUI;

public class BaseUIActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SystemUI.fixSystemUI(this);
    }
}
