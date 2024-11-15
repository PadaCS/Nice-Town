package com.bupt.nicetown.pojo;

import java.sql.Timestamp;

public class SupSucceed {
    private int promoteID;
    private int promoter;
    private int supportID;
    private int supporter;
    private Timestamp acceptTime;

    // 无参构造器
    public SupSucceed() {}

    // 带参构造器
    public SupSucceed(int promoteID, int promoter, int supportID, int supporter, Timestamp acceptTime) {
        this.promoteID = promoteID;
        this.promoter = promoter;
        this.supportID = supportID;
        this.supporter = supporter;
        this.acceptTime = acceptTime;
    }

    public int getPromoteID() {
        return promoteID;
    }

    public void setPromoteID(int promoteID) {
        this.promoteID = promoteID;
    }

    public int getPromoter() {
        return promoter;
    }

    public void setPromoter(int promoter) {
        this.promoter = promoter;
    }

    public int getSupportID() {
        return supportID;
    }

    public void setSupportID(int supportID) {
        this.supportID = supportID;
    }

    public int getSupporter() {
        return supporter;
    }

    public void setSupporter(int supporter) {
        this.supporter = supporter;
    }

    public Timestamp getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(Timestamp acceptTime) {
        this.acceptTime = acceptTime;
    }
}
