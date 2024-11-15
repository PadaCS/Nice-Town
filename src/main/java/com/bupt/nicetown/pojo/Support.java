package com.bupt.nicetown.pojo;

import java.sql.Timestamp;

public class Support {
    private int supportID;
    private int promoteID;
    private int userID;
    private String supDescrip;
    private String supFiles;
    private Timestamp createTime;
    private Timestamp lastModified;
    private int status;

    // 无参构造器
    public Support() {}

    // 带参构造器
    public Support(int supportID, int promoteID, int userID, String supDescrip, String supFiles,
                   Timestamp createTime, Timestamp lastModified, int status) {
        this.supportID = supportID;
        this.promoteID = promoteID;
        this.userID = userID;
        this.supDescrip = supDescrip;
        this.supFiles = supFiles;
        this.createTime = createTime;
        this.lastModified = lastModified;
        this.status = status;
    }

    public int getSupportID() {
        return supportID;
    }

    public void setSupportID(int supportID) {
        this.supportID = supportID;
    }

    public int getPromoteID() {
        return promoteID;
    }

    public void setPromoteID(int promoteID) {
        this.promoteID = promoteID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getSupDescrip() {
        return supDescrip;
    }

    public void setSupDescrip(String supDescrip) {
        this.supDescrip = supDescrip;
    }

    public String getSupFiles() {
        return supFiles;
    }

    public void setSupFiles(String supFiles) {
        this.supFiles = supFiles;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

