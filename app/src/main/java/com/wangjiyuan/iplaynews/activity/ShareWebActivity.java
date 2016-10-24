package com.wangjiyuan.iplaynews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import com.wangjiyuan.iplaynews.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShareWebActivity extends AppCompatActivity {

    @BindView(R.id.content)
    WebView content;
    @BindView(R.id.activity_share_web)
    RelativeLayout activityShareWeb;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_web);
        ButterKnife.bind(this);
        initToolBar();
        WebViewSetting();
        initView();
        initData();
    }

    private void initToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initData() {
        Intent intent = getIntent();
        String url = intent.getStringExtra(MainActivity.GET_URL);
        Log.e("url", url);
        content.loadUrl(url);
    }

    private void WebViewSetting() {
        content.setInitialScale(100);
        WebSettings settings = content.getSettings();
        settings.setJavaScriptEnabled(false);
    }

    private void initView() {
        content.setWebViewClient(new WebViewClient() {
            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
