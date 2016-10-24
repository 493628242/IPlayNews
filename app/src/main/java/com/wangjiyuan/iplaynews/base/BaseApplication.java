package com.wangjiyuan.iplaynews.base;

import android.app.Application;
import android.database.ContentObservable;
import android.graphics.Bitmap;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.litesuits.orm.LiteOrm;

import okhttp3.OkHttpClient;

/**
 * Created by wjy on 2016/10/14.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initFresco();
        initLiteOrm();

    }

    public static final String DB_NAME = "collection.db";
    public static LiteOrm liteOrm;

    private void initLiteOrm() {
        if (liteOrm == null) {
            liteOrm = LiteOrm.newSingleInstance(this, DB_NAME);
        }
        liteOrm.setDebugged(true); // open the log
    }

    private void initFresco() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        ImagePipelineConfig config = OkHttpImagePipelineConfigFactory.
                newBuilder(this, okHttpClient)
                .setBitmapsConfig(Bitmap.Config.RGB_565)
                .build();
        Fresco.initialize(this, config);
    }

    /*private void initPicasso() {
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
    }*/
}
