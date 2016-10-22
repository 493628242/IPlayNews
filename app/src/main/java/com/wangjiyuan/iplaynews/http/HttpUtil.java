package com.wangjiyuan.iplaynews.http;

import com.wangjiyuan.iplaynews.javabean.HeadInfo;
import com.wangjiyuan.iplaynews.javabean.InfoBean;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by wjy on 2016/10/22.
 */

public class HttpUtil {
    private HttpUtil() {
        retrofit = new Retrofit.Builder()
                .baseUrl(HttpUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        api = retrofit.create(RetrofitApi.class);
    }

    private static HttpUtil httpUtil;
    private Retrofit retrofit;
    private RetrofitApi api;

    public static HttpUtil newInstance() {
        if (httpUtil == null) {
            httpUtil = new HttpUtil();
        }
        return httpUtil;
    }

    public Observable<HeadInfo> getInfor(String apistring) {
        return api.getBean(apistring);
    }
}
