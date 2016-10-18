package com.wangjiyuan.iplaynews.base;

import android.app.Application;

import com.squareup.picasso.LruCache;
import com.squareup.picasso.Picasso;

/**
 * Created by DELL on 2016/10/14.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initPicasso();
    }

    private void initPicasso() {
        Picasso picasso = new Picasso.Builder(this)
                //设置内存缓存大小10M
                .memoryCache(new LruCache(10 << 20))
                //设置左上角标记，主要用于测试
                //红色-从网络下载
                //蓝色-从磁盘加载
                //绿色-从内存加载
                .indicatorsEnabled(true)
                .build();
        //设置Picasso单例模式
        Picasso.setSingletonInstance(picasso);
    }
}
