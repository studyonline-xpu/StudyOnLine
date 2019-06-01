package com.study_online.pojo;

import java.io.Serializable;

public class VideoClass implements Serializable {
    private String classId;

    private String className;

    private String fastherId;

    private Boolean isFather;

    private static final long serialVersionUID = 1L;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getFastherId() {
        return fastherId;
    }

    public void setFastherId(String fastherId) {
        this.fastherId = fastherId == null ? null : fastherId.trim();
    }

    public Boolean getIsFather() {
        return isFather;
    }

    public void setIsFather(Boolean isFather) {
        this.isFather = isFather;
    }
}