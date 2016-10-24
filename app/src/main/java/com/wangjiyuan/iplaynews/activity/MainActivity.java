package com.wangjiyuan.iplaynews.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.wangjiyuan.iplaynews.R;
import com.wangjiyuan.iplaynews.adapter.ViewPagerAdapter;
import com.wangjiyuan.iplaynews.base.BaseActivity;
import com.wangjiyuan.iplaynews.fragment.NewsListFragment;
import com.yztc.zxinglibrary.android.CaptureActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    public static final String[] TYPES = {"",
            "T1461396384709", "T1461396358842",
            "T1461396291717", "T1461396413033", "T1461396489605"};
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager_news_content)
    ViewPager viewPagerNewsContent;
    private long fisttime;
    private long secondtime;
    private PopupWindow mPopupWindow;
    public static final String GET_URL = "get_url";
    public static final String TYPE = "type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        iniView();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.e("key", keyCode + "");
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                secondtime = System.currentTimeMillis();
                if ((secondtime - fisttime) < 2000) {
                    return super.onKeyDown(keyCode, event);
                } else {
                    fisttime = secondtime;
                    Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
                }
                break;
            case KeyEvent.KEYCODE_MENU:
                mPopupWindow.showAtLocation(viewPagerNewsContent, Gravity.BOTTOM, 0, 0);
                break;
        }
        return false;
    }

    private void initPopupWindow() {
        View popupView = getLayoutInflater().inflate(R.layout.popupwindow_layout, null);
        mPopupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.menu_tab)));
        ImageButton mycollection = (ImageButton) popupView.findViewById(R.id.my_collection);
        ImageButton erweima = (ImageButton) popupView.findViewById(R.id.erweima);
        mycollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CollectionListActivity.class);
                startActivity(intent);
                mPopupWindow.dismiss();
            }
        });

        erweima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                startActivityForResult(intent, 0);
                mPopupWindow.dismiss();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            Intent intent = data;
            intent.setClass(MainActivity.this, ShareWebActivity.class);
            String content = intent.getStringExtra(GET_URL);

//            Log.e("content", content);
            startActivity(intent);

        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void iniView() {
        initPopupWindow();
        tabLayout.setupWithViewPager(viewPagerNewsContent, true);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setBackgroundColor(Color.BLACK);
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < TYPES.length; ++i) {
            NewsListFragment fragment = new NewsListFragment();
            Bundle bundle = new Bundle();
            bundle.putString(TYPE, TYPES[i]);
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        viewPagerNewsContent.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragments));
    }
}
