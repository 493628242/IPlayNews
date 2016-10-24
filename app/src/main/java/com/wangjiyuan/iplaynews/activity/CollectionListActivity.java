package com.wangjiyuan.iplaynews.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.wangjiyuan.iplaynews.R;
import com.wangjiyuan.iplaynews.adapter.RecycleAdapter;
import com.wangjiyuan.iplaynews.base.BaseApplication;
import com.wangjiyuan.iplaynews.javabean.InfoBean;

import java.util.ArrayList;
import java.util.TreeSet;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CollectionListActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.activity_collection_list)
    LinearLayout activityCollectionList;
    private RecycleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_list);
        ButterKnife.bind(this);
        initToolBar();

    }

    @Override
    protected void onResume() {
        super.onResume();
        initView();
    }

    private void initView() {
        LiteOrm liteOrm = BaseApplication.liteOrm;
        ArrayList<InfoBean> query = liteOrm.query(InfoBean.class);
        TreeSet<InfoBean> set = new TreeSet<>();
        set.addAll(query);
        adapter = new RecycleAdapter(this, set);
        recycleView.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recycleView.setLayoutManager(manager);
    }

    private void initToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
