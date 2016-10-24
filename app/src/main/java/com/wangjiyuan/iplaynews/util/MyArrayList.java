package com.wangjiyuan.iplaynews.util;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by DELL on 2016/10/24.
 */

public class MyArrayList<E> extends ArrayList<E> {
    //重写toString方法
    @Override
    public String toString() {
        Iterator iterator = this.iterator();
        String string = "";
        while (iterator.hasNext()) {
            if (!string.isEmpty()) {
                string += ",";
            }
            string += iterator.next().toString();
        }

        return string;
    }
}
