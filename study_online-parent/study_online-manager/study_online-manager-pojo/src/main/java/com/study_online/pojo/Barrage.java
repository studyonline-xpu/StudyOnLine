package com.study_online.pojo;

import java.io.Serializable;

public class Barrage implements Serializable {
    private String barrageId;

    private String msg;

    private String color;

    private Double time;

    private String catalogId;

    private static final long serialVersionUID = 1L;

    public String getBarrageId() {
        return barrageId;
    }

    public void setBarrageId(String barrageId) {
        this.barrageId = barrageId == null ? null : barrageId.trim();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId == null ? null : catalogId.trim();
    }
}