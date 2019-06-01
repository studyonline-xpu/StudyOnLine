package com.study_online.pojo;

import java.io.Serializable;
import java.util.Date;

public class Catalog implements Serializable {
    private String catalogId;

    private String catalogName;

    private String fatherId;

    private Boolean isFather;

    private String formarId;

    private String latterId;

    private String videoId;

    private Date uploadTime;

    private String videoUrl;

    private static final long serialVersionUID = 1L;

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId == null ? null : catalogId.trim();
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName == null ? null : catalogName.trim();
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

    public String getFormarId() {
        return formarId;
    }

    public void setFormarId(String formarId) {
        this.formarId = formarId == null ? null : formarId.trim();
    }

    public String getLatterId() {
        return latterId;
    }

    public void setLatterId(String latterId) {
        this.latterId = latterId == null ? null : latterId.trim();
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId == null ? null : videoId.trim();
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }
}