package com.wangjiyuan.iplaynews.http;

import com.wangjiyuan.iplaynews.javabean.HeadInfo;
import com.wangjiyuan.iplaynews.javabean.InfoBean;

import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by wjy on 2016/10/22.
 */

public interface RetrofitApi {
    @GET("user/article/list/{topicId}/0/10")
    Observable<HeadInfo> getBean(@Path("topicId") String apistring);
}
