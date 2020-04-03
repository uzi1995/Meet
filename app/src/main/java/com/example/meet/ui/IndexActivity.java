package com.example.meet.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

import com.example.framework.entity.Constants;
import com.example.framework.utils.SpUtils;
import com.example.meet.MainActivity;
import com.example.meet.R;

//启动页
public class IndexActivity extends AppCompatActivity {

    private static final int SKIP_MIAN = 1000;

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch(msg.what){
                case SKIP_MIAN:
                    startMain();
                    break;
            }
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        mHandler.sendEmptyMessageDelayed(SKIP_MIAN, 2*1000);
    }

    //进入主页
    private void startMain() {
        SpUtils.getInstance().initSp(this);
        //判断APP是否第一次启动
        boolean isFirstApp = SpUtils.getInstance().getBoolean(Constants.SP_IS_FIRST_APP, true);
        Intent intent = new Intent();
        if(isFirstApp){
            //跳转到引导页
            intent.setClass(this, GuideActivity.class);
            //非第一次启动
            SpUtils.getInstance().putBoolean(Constants.SP_TOKEN, false);
        }else{
            //判断是否曾经登录过
            String token = SpUtils.getInstance().getString(Constants.SP_TOKEN, "");
            if(TextUtils.isEmpty(token)){
                //跳转到登录页
                intent.setClass(this, LoginActivity.class);
            }else{
                //跳转到主页
                intent.setClass(this, MainActivity.class);
            }
        }
        startActivity(intent);
        finish();
    }
}
