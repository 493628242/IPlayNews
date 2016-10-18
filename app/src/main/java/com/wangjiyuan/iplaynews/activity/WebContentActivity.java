package com.wangjiyuan.iplaynews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wangjiyuan.iplaynews.R;
import com.wangjiyuan.iplaynews.adapter.RecycleAdapter;
import com.wangjiyuan.iplaynews.javabean.HeadInfo;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebContentActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.content)
    WebView content;
    @BindView(R.id.start_publish)
    TextView startPublish;
    @BindView(R.id.comment_img)
    ImageView commentImg;
    @BindView(R.id.comment_tv)
    TextView commentTv;
    @BindView(R.id.collection)
    ImageView collection;
    @BindView(R.id.share)
    ImageView share;
    @BindView(R.id.close)
    ImageView close;
    @BindView(R.id.publish)
    TextView publish;
    @BindView(R.id.comment_content)
    EditText commentContent;
    @BindView(R.id.comment_interface)
    LinearLayout commentInterface;
    @BindView(R.id.show)
    LinearLayout show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_content);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(RecycleAdapter.INFO_BUNDLE);
        HeadInfo.InfoBean info = (HeadInfo.InfoBean) bundle.get(RecycleAdapter.INFO);
        commentTv.setText(String.valueOf(info.getReplyCount()));
    }

    private void initView() {
        commentInterface.setVisibility(View.GONE);
        startPublish.setOnClickListener(this);
        commentImg.setOnClickListener(this);
        collection.setOnClickListener(this);
        share.setOnClickListener(this);
        close.setOnClickListener(this);
        publish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_publish:
                //打开评论输入界面
                commentInterface.setVisibility(View.VISIBLE);
                show.setVisibility(View.GONE);
                commentContent.findFocus();
                break;
            case R.id.comment_img:
                //跳转评论界面
                Toast.makeText(WebContentActivity.this, "跳转评论界面", Toast.LENGTH_SHORT).show();
                break;
            case R.id.collection:
                //收藏此条新闻
                Toast.makeText(WebContentActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share:
                //分享
                Toast.makeText(WebContentActivity.this, "分享", Toast.LENGTH_SHORT).show();
                break;
            case R.id.publish:
                //发表评论
                Toast.makeText(WebContentActivity.this, "发表评论成功", Toast.LENGTH_SHORT).show();
            case R.id.close:
                //关闭输入评论栏
                show.setVisibility(View.VISIBLE);
                commentInterface.setVisibility(View.GONE);
                break;
        }
    }
}
