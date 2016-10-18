package com.wangjiyuan.iplaynews.util;

/**
 * Created by DELL on 2016/10/14.
 */
public class StringUitl {

    public static final String TYPE_5_MODE="{\"imgextra\":%s}";

    /**
     *
     * 用于获取
     * @param imgstring
     * @return
     */
    public  static String getType_5(String imgstring){
        return String.format(TYPE_5_MODE,imgstring);
    }
}
