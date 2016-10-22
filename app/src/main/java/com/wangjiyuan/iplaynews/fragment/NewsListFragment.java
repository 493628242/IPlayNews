package com.wangjiyuan.iplaynews.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wangjiyuan.iplaynews.R;
import com.wangjiyuan.iplaynews.adapter.RecycleAdapter;
import com.wangjiyuan.iplaynews.base.BaseFragment;
import com.wangjiyuan.iplaynews.http.HttpUtil;
import com.wangjiyuan.iplaynews.javabean.HeadInfo;
import com.wangjiyuan.iplaynews.javabean.InfoBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * A simple {@link Fragment} subclass.
 * http://i.play.163.com/user/article/list/<T1461396384709>/0/10 网游
 * http://i.play.163.com/user/article/list/0/10 头条
 * http://i.play.163.com/user/article/list/<T1461396358842>/0/10 手游
 * http://i.play.163.com/user/article/list/<T1461396291717>/0/10 主机
 * http://i.play.163.com/user/article/list/<T1461396413033>/0/10 电竞
 * http://i.play.163.com/user/article/list/<T1461396489605>/0/10 暴雪
 * <>内为topicId
 */
public class NewsListFragment extends BaseFragment {

    public static final String URL = "http://i.play.163.com/user/article/list%s/0/10";
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    private String type;
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    private List<InfoBean> list;
    private Subscription subscribe;

    public NewsListFragment() {
    }

    public NewsListFragment(String type) {
        this.type = type;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.refresh_layout, container, false);
        ButterKnife.bind(this, rootView);
        RefreshSetting();
        initData();
        return rootView;
    }

    private void initData() {
        //数据加载
        HttpUtil httpUtil = HttpUtil.newInstance();
        subscribe = httpUtil.getInfor(type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HeadInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getContext(), "无法连接网络", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(HeadInfo headInfo) {
                        list = new ArrayList<>();
                        list.addAll(0, headInfo.getInfo());
                        recycleView.setAdapter(new RecycleAdapter(getContext(), list));
                        LinearLayoutManager manager = new LinearLayoutManager(getContext(),
                                LinearLayoutManager.VERTICAL, false);
                        recycleView.setLayoutManager(manager);
                    }
                });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        subscribe.unsubscribe();
    }

    private void RefreshSetting() {
        refresh.setProgressBackgroundColorSchemeColor(Color.WHITE);
        refresh.setDrawingCacheBackgroundColor(Color.BLACK);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData();
                refresh.setRefreshing(false);
            }
        });

    }
}
