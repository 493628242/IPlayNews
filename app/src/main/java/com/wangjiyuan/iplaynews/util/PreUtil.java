package com.wangjiyuan.iplaynews.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by DELL on 2016/10/10.
 * sharedPreferences的工具类
 */
public class PreUtil {
    private static SharedPreferences getSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    /**
     * 写入boolean
     *
     * @param context
     * @param Key
     * @param vaule
     */

    public static void putBoolean(Context context, String Key, Boolean vaule) {
        getSharedPreferences(context).edit().putBoolean(Key, vaule).commit();
    }

    /**
     * 读取boolean
     *
     * @param context
     * @param key
     * @return
     */
    public static boolean getBoolean(Context context, String key) {
        return getSharedPreferences(context).getBoolean(key, false);
    }
}
