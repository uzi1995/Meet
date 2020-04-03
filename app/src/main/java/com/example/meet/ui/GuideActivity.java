package com.example.meet.ui;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.example.framework.base.BasePageAdapter;
import com.example.framework.base.BaseUIActivity;
import com.example.meet.R;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends BaseUIActivity {

    private ViewPager mViewPager;
    private ImageView iv_music_switch;
    private TextView tv_guide_skip;
    private ImageView iv_guide_point_1;
    private ImageView iv_guide_point_2;
    private ImageView iv_guide_point_3;

    private View view1;
    private View view2;
    private View view3;

    private List<View> mPageList = new ArrayList<>();

    private BasePageAdapter mPageAdapter;

    private ImageView iv_guide_star;
    private ImageView iv_guide_night;
    private ImageView iv_guide_smile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.mViewPager);
        iv_music_switch = (ImageView) findViewById(R.id.iv_music_switch);
        tv_guide_skip = (TextView) findViewById(R.id.tv_guide_skip);
        iv_guide_point_1 = (ImageView) findViewById(R.id.iv_guide_point_1);
        iv_guide_point_2 = (ImageView) findViewById(R.id.iv_guide_point_2);
        iv_guide_point_3 = (ImageView) findViewById(R.id.iv_guide_point_3);

        view1 = View.inflate(this, R.layout.layout_pager_guide_1, null);
        view2 = View.inflate(this, R.layout.layout_pager_guide_2, null);
        view3 = View.inflate(this, R.layout.layout_pager_guide_3, null);

        mPageList.add(view1);
        mPageList.add(view2);
        mPageList.add(view3);

        //预加载
        mViewPager.setOffscreenPageLimit(mPageList.size());

        mPageAdapter = new BasePageAdapter(mPageList);
        mViewPager.setAdapter(mPageAdapter);

        //帧动画
        iv_guide_star = view1.findViewById(R.id.iv_guide_star);
        iv_guide_night = view2.findViewById(R.id.iv_guide_night);
        iv_guide_smile = view3.findViewById(R.id.iv_guide_smile);

//        播放帧动画
        AnimationDrawable animStar = (AnimationDrawable)iv_guide_star.getBackground();
        animStar.start();
        AnimationDrawable animNight = (AnimationDrawable)iv_guide_night.getBackground();
        animNight.start();
        AnimationDrawable animSmile = (AnimationDrawable)iv_guide_smile.getBackground();
        animSmile.start();

    }
}
