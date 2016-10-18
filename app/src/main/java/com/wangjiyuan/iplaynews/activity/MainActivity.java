package com.wangjiyuan.iplaynews.activity;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.wangjiyuan.iplaynews.R;
import com.wangjiyuan.iplaynews.adapter.ViewPagerAdapter;
import com.wangjiyuan.iplaynews.base.BaseActivity;
import com.wangjiyuan.iplaynews.fragment.NewsListFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    public static final String[] TYPES = {"",
            "/T1461396384709", "/T1461396358842",
            "/T1461396291717", "/T1461396413033", "/T1461396489605"};
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager_news_content)
    ViewPager viewPagerNewsContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        iniView();
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void iniView() {
        tabLayout.setupWithViewPager(viewPagerNewsContent, true);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setBackgroundColor(Color.BLACK);
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < TYPES.length; ++i) {
            fragments.add(new NewsListFragment(TYPES[i]));
        }
        viewPagerNewsContent.setOffscreenPageLimit(TYPES.length - 1);
        viewPagerNewsContent.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragments));
    }
}