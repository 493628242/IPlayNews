package com.wangjiyuan.iplaynews.javabean;

import com.litesuits.orm.db.annotation.Ignore;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;
import com.wangjiyuan.iplaynews.util.MyArrayList;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wjy on 2016/10/22.
 */
@Table("info_bean")
public class InfoBean implements Serializable, Comparable {
    private String boardid;
    private String digest;
    @PrimaryKey(AssignType.BY_MYSELF)
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
    @Ignore
    private Object imgextra;
    private MyArrayList<String> imgsrc;

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

    public MyArrayList<String> getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(List<String> imgsrc) {
        this.imgsrc = (MyArrayList) imgsrc;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InfoBean bean = (InfoBean) o;

        if (fromTopicSource != bean.fromTopicSource) return false;
        if (priority != bean.priority) return false;
        if (replyCount != bean.replyCount) return false;
        if (showType != bean.showType) return false;
        if (userOrder != bean.userOrder) return false;
        if (boardid != null ? !boardid.equals(bean.boardid) : bean.boardid != null) return false;
        if (digest != null ? !digest.equals(bean.digest) : bean.digest != null) return false;
        if (docid != null ? !docid.equals(bean.docid) : bean.docid != null) return false;
        if (lmodify != null ? !lmodify.equals(bean.lmodify) : bean.lmodify != null) return false;
        if (ltitle != null ? !ltitle.equals(bean.ltitle) : bean.ltitle != null) return false;
        if (postid != null ? !postid.equals(bean.postid) : bean.postid != null) return false;
        if (ptime != null ? !ptime.equals(bean.ptime) : bean.ptime != null) return false;
        if (source != null ? !source.equals(bean.source) : bean.source != null) return false;
        if (subtitle != null ? !subtitle.equals(bean.subtitle) : bean.subtitle != null)
            return false;
        if (title != null ? !title.equals(bean.title) : bean.title != null) return false;
        if (tname != null ? !tname.equals(bean.tname) : bean.tname != null) return false;
        if (topicId != null ? !topicId.equals(bean.topicId) : bean.topicId != null) return false;
        if (url != null ? !url.equals(bean.url) : bean.url != null) return false;
        if (url3w != null ? !url3w.equals(bean.url3w) : bean.url3w != null) return false;
        if (imgextra != null ? !imgextra.equals(bean.imgextra) : bean.imgextra != null)
            return false;
        return imgsrc != null ? imgsrc.equals(bean.imgsrc) : bean.imgsrc == null;

    }

    @Override
    public int hashCode() {
        int result = boardid != null ? boardid.hashCode() : 0;
        result = 31 * result + (digest != null ? digest.hashCode() : 0);
        result = 31 * result + (docid != null ? docid.hashCode() : 0);
        result = 31 * result + (fromTopicSource ? 1 : 0);
        result = 31 * result + (lmodify != null ? lmodify.hashCode() : 0);
        result = 31 * result + (ltitle != null ? ltitle.hashCode() : 0);
        result = 31 * result + (postid != null ? postid.hashCode() : 0);
        result = 31 * result + priority;
        result = 31 * result + (ptime != null ? ptime.hashCode() : 0);
        result = 31 * result + replyCount;
        result = 31 * result + showType;
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (subtitle != null ? subtitle.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (tname != null ? tname.hashCode() : 0);
        result = 31 * result + (topicId != null ? topicId.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (url3w != null ? url3w.hashCode() : 0);
        result = 31 * result + (userOrder ? 1 : 0);
        result = 31 * result + (imgextra != null ? imgextra.hashCode() : 0);
        result = 31 * result + (imgsrc != null ? imgsrc.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Object o) {
        //增加可比较性
        InfoBean bean = (InfoBean) o;
        if (priority < bean.priority) {
            return 1;
        } else if (priority > bean.priority) {
            return -1;
        } else {
            return bean.ptime.compareTo(ptime);
        }
    }
}
