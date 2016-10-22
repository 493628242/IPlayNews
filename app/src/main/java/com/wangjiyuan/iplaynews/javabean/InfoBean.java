package com.wangjiyuan.iplaynews.javabean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wjy on 2016/10/22.
 */
public class InfoBean implements Serializable {
    private String boardid;
    private String digest;
    private String docid;
    private boolean fromTopicSource;
    private String lmodify;
    private String ltitle;
    private String postid;
    private int priority;
    private String ptime;
    private int replyCount;
    private int showType;
    private String source;
    private String subtitle;
    private String title;
    private String tname;
    private String topicId;
    private String url;
    private String url3w;
    private boolean userOrder;
    private Object imgextra;
    private List<String> imgsrc;

    public String getBoardid() {
        return boardid;
    }

    public void setBoardid(String boardid) {
        this.boardid = boardid;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public boolean isFromTopicSource() {
        return fromTopicSource;
    }

    public void setFromTopicSource(boolean fromTopicSource) {
        this.fromTopicSource = fromTopicSource;
    }

    public String getLmodify() {
        return lmodify;
    }

    public void setLmodify(String lmodify) {
        this.lmodify = lmodify;
    }

    public String getLtitle() {
        return ltitle;
    }

    public void setLtitle(String ltitle) {
        this.ltitle = ltitle;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public int getShowType() {
        return showType;
    }

    public void setShowType(int showType) {
        this.showType = showType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl3w() {
        return url3w;
    }

    public void setUrl3w(String url3w) {
        this.url3w = url3w;
    }

    public boolean isUserOrder() {
        return userOrder;
    }

    public void setUserOrder(boolean userOrder) {
        this.userOrder = userOrder;
    }

    public Object getImgextra() {
        return imgextra;
    }

    public void setImgextra(Object imgextra) {
        this.imgextra = imgextra;
    }

    public List<String> getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(List<String> imgsrc) {
        this.imgsrc = imgsrc;
    }
}
