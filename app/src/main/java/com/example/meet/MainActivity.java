package com.example.meet;

import android.os.Bundle;
import android.widget.Toast;


import com.example.framework.base.BaseUIActivity;
import com.example.framework.bmob.BmobManager;
import com.example.framework.bmob.IMUser;
import com.example.framework.utils.LogUtils;

import java.util.List;

import cn.bmob.v3.BmobUser;

public class MainActivity extends BaseUIActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void requestPermiss() {
        //危险权限
        request(new OnPermissionsResult() {
            @Override
            public void OnSuccess() {

            }

            @Override
            public void OnFail(List<String> noPermissions) {
                LogUtils.i("noPermissions:" + noPermissions.toString());
            }
        });
    }
}
