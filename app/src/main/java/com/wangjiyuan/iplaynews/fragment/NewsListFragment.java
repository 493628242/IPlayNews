package com.wangjiyuan.iplaynews.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.wangjiyuan.iplaynews.R;
import com.wangjiyuan.iplaynews.adapter.RecycleAdapter;
import com.wangjiyuan.iplaynews.base.BaseFragment;
import com.wangjiyuan.iplaynews.javabean.HeadInfo;
import com.wangjiyuan.iplaynews.util.OkhttpUitl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


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
    private String type;
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    private List<HeadInfo.InfoBean> list;

    public NewsListFragment() {
    }

    public NewsListFragment(String type) {
        this.type = type;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news_list, container, false);
        initData();
        initView(rootView);

        ButterKnife.bind(this, rootView);
        return rootView;
    }

    private void initView(View rootView) {

    }

    private void initData() {
        String url = String.format(URL, type);
        OkhttpUitl.getAsyncString(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Gson gson = new Gson();
                HeadInfo headInfo = gson.fromJson(json, HeadInfo.class);
                list = new ArrayList<>();
                list.addAll(0, headInfo.getInfo());
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recycleView.setAdapter(new RecycleAdapter(getContext(), list));
                        LinearLayoutManager manager = new LinearLayoutManager(getContext(),
                                LinearLayoutManager.VERTICAL, false);
                        recycleView.setLayoutManager(manager);
                    }
                });
            }
        });
    }
}
