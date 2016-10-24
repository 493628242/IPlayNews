package com.wangjiyuan.iplaynews.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.zxing.WriterException;
import com.wangjiyuan.iplaynews.R;
import com.yztc.zxinglibrary.encode.CodeCreator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ErWeiMaActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.erweima)
    ImageView erweima;
    @BindView(R.id.activity_er_wei_ma)
    RelativeLayout activityErWeiMa;
    private String used_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_er_wei_ma);
        ButterKnife.bind(this);
        initData();
        initToolBar();
        initerweima();
    }

    private void initData() {
        Intent intent = getIntent();
        used_url = intent.getStringExtra(WebContentActivity.URL);
    }

    private void initToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initerweima() {
        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        Bitmap qrCode = null;
        try {
            qrCode = CodeCreator.createQRCodeWithIcon(used_url, icon);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        erweima.setImageBitmap(qrCode);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
