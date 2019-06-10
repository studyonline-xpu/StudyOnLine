package com.study_online.pojo;

import java.io.Serializable;
import java.util.Date;

public class Comments implements Serializable {
    private String commentsId;

    private String fromId;

    private String toId;

    private String fatherId;

    private Boolean isFather;

    private Date time;

    private String msg;

    //添加属性
    private String fromName;
    private String fromPicture;

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getFromPicture() {
        return fromPicture;
    }
    //结束

    public void setFromPicture(String fromPicture) {
        this.fromPicture = fromPicture;
    }

    private static final long serialVersionUID = 1L;

    public String getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(String commentsId) {
        this.commentsId = commentsId == null ? null : commentsId.trim();
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId == null ? null : fromId.trim();
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId == null ? null : toId.trim();
    }

    public String getFatherId() {
        return fatherId;
    }

    public void setFatherId(String fatherId) {
        this.fatherId = fatherId == null ? null : fatherId.trim();
    }

    public Boolean getIsFather() {
        return isFather;
    }

    public void setIsFather(Boolean isFather) {
        this.isFather = isFather;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }
}