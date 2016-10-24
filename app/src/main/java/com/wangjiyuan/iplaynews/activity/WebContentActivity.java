package com.wangjiyuan.iplaynews.activity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.litesuits.orm.LiteOrm;
import com.wangjiyuan.iplaynews.R;
import com.wangjiyuan.iplaynews.adapter.RecycleAdapter;
import com.wangjiyuan.iplaynews.base.BaseActivity;
import com.wangjiyuan.iplaynews.base.BaseApplication;
import com.wangjiyuan.iplaynews.javabean.HeadInfo;
import com.wangjiyuan.iplaynews.javabean.InfoBean;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebContentActivity extends BaseActivity implements View.OnClickListener {

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
    private InfoBean info;
    private PopupWindow mPopupWindow;
    public static final String URL = "url";
    private String used_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_content);
        ButterKnife.bind(this);
        WebViewSetting();

        initData();
        initView();
    }

    private void WebViewSetting() {
        content.setInitialScale(100);
        WebSettings settings = content.getSettings();
        settings.setJavaScriptEnabled(false);
    }

    private void initData() {
        //显示网页
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(RecycleAdapter.INFO_BUNDLE);
        info = (InfoBean) bundle.get(RecycleAdapter.INFO);
        commentTv.setText(String.valueOf(info.getReplyCount()));
        if (!info.getUrl3w().isEmpty()) {
            used_url = info.getUrl3w();
            content.loadUrl(used_url);
        } else {
            used_url = info.getUrl();
            content.loadUrl(used_url);
        }
        InfoBean bean = BaseApplication.liteOrm.queryById(info.getDocid(), InfoBean.class);
        if (bean != null) {
            collection.setImageResource(R.drawable.btn_pgnews_save2);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        content.stopLoading();
        ((ViewGroup) content.getParent()).removeView(content);
        content.removeAllViews();
        content.clearCache(true);
        content.clearHistory();
        content.destroy();
    }

    private void initView() {
        commentInterface.setVisibility(View.GONE);
        startPublish.setOnClickListener(this);
        commentImg.setOnClickListener(this);
        collection.setOnClickListener(this);
        share.setOnClickListener(this);
        close.setOnClickListener(this);
        publish.setOnClickListener(this);

        content.setWebViewClient(new WebViewClient() {
            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
            }
        });
        initPopupWindow();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if (commentInterface.getVisibility() == View.VISIBLE) {
                    //如果评论界面显示则关闭评论界面
                    show.setVisibility(View.VISIBLE);
                    commentInterface.setVisibility(View.GONE);
                    return false;
                } else {
                    return super.onKeyDown(keyCode, event);
                }
            case KeyEvent.KEYCODE_MENU:

        }
        return super.onKeyDown(keyCode, event);

    }

    private void initPopupWindow() {
        View popupView = getLayoutInflater().inflate(R.layout.share_erweima, null);
        mPopupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.menu_tab)));
        ImageButton erweima = (ImageButton) popupView.findViewById(R.id.erweima);
        erweima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WebContentActivity.this, ErWeiMaActivity.class);
                intent.putExtra(URL, used_url);
                startActivity(intent);
                mPopupWindow.dismiss();
            }
        });

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
                //Toast.makeText(WebContentActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
                LiteOrm liteOrm = BaseApplication.liteOrm;
                InfoBean bean = liteOrm.queryById(info.getDocid(), InfoBean.class);
                if (bean != null) {
                    ((ImageView) v).setImageResource(R.drawable.btn_pgnews_save1);
                    liteOrm.delete(bean);
                    Toast.makeText(WebContentActivity.this, "取消收藏", Toast.LENGTH_SHORT).show();
                } else {
                    ((ImageView) v).setImageResource(R.drawable.btn_pgnews_save2);
                    liteOrm.insert(info);
                    Toast.makeText(WebContentActivity.this, "添加收藏", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.share:
                //分享
                Toast.makeText(WebContentActivity.this, "分享", Toast.LENGTH_SHORT).show();
                mPopupWindow.showAtLocation(content, Gravity.CENTER, 0, 0);
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
