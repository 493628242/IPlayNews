package com.wangjiyuan.iplaynews.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by DELL on 2016/10/11.
 */
public class OkhttpUitl {

    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

    /**
     * 未开启异步任务
     *
     * @param url
     * @return
     * @throws IOException
     */

    public static String getString(String url) throws IOException {
        Request build = new Request.Builder().url(url).build();
        Response response = okHttpClient.newCall(build).execute();
        ResponseBody body = response.body();
        return body.string();

    }

    /**
     * 未开启异步任务
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static Bitmap getBitmap(String url) throws IOException {
        Request build = new Request.Builder().url(url).build();
        Response response = okHttpClient.newCall(build).execute();
        InputStream in = response.body().byteStream();
        return BitmapFactory.decodeStream(in);

    }


    public static void getAsyncString(String url, Callback callback) {
        Request build = new Request.Builder().url(url).build();
        okHttpClient.newCall(build).enqueue(callback);
    }

    public static void getAsyncBitmap(String url, Callback callback) {
        Request build = new Request.Builder().url(url).build();
        okHttpClient.newCall(build).enqueue(callback);
    }

}
