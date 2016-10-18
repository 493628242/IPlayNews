package com.wangjiyuan.iplaynews.javabean;

import java.util.List;

/**
 * Created by DELL on 2016/10/14.
 */
public class ShowType_5 {

    /**
     * imgsrc : http://img1.cache.netease.com/game/gamedata/news/201610/20161014-yakuza6-new-p2g.jpg
     */

    private List<ImgextraBean> imgextra;

    public List<ImgextraBean> getImgextra() {
        return imgextra;
    }

    public void setImgextra(List<ImgextraBean> imgextra) {
        this.imgextra = imgextra;
    }

    public static class ImgextraBean {
        private String imgsrc;

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }
    }
}
