package com.example.framework.bmob;

import android.content.Context;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.QueryListener;

public class BmobManager {
    private static final String BMOB_SDK_ID = "c6667f24cb6948ebeb42dfefb3b4e55d";

    private volatile static BmobManager mInstance = null;
    private BmobManager(){

    }

    public static BmobManager getInstance(){
        if(mInstance == null){
            synchronized (BmobManager.class){
                if(mInstance == null){
                    mInstance = new BmobManager();
                }
            }
        }
        return mInstance;
    }

    //初始化Bmob
    public void initBmob(Context mContext){
        Bmob.initialize(mContext, BMOB_SDK_ID);
    }

    //判断是否登录
    public boolean isLogin(){
        return BmobUser.isLogin();
    }

    //获取本地对象
    public IMUser getUser(){
        return BmobUser.getCurrentUser(IMUser.class);
    }

    //发送短信验证码
    public void requestSMS(String phone, QueryListener<Integer> listener){
        BmobSMS.requestSMSCode(phone, "", listener);
    }

    //通过手机号码注册或者登录
    public void signOrLoginByMobilePhone(String phone, String code, LogInListener<IMUser> listener) {
        BmobUser.signOrLoginByMobilePhone(phone, code, listener);
    }
}
