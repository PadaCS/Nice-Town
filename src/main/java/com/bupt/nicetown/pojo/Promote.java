package com.bupt.nicetown.pojo;

import java.sql.Timestamp;

public class Promote {
    private int promoteID;
    private int promotterID;
    private int townID;
    private String promotType;
    private String theme;
    private String proDescrip;
    private String promFiles;
    private Timestamp createTime;
    private Timestamp lastModified;
    private int status;

    // 无参构造器
    public Promote() {}

    // 带参构造器
    public Promote(int promoteID, int promotterID, int townID, String promotType, String theme,
                   String proDescrip, String promFiles, Timestamp createTime,
                   Timestamp lastModified, int status) {
        this.promoteID = promoteID;
        this.promotterID = promotterID;
        this.townID = townID;
        this.promotType = promotType;
        this.theme = theme;
        this.proDescrip = proDescrip;
        this.promFiles = promFiles;
        this.createTime = createTime;
        this.lastModified = lastModified;
        this.status = status;
    }

    public int getPromoteID() {
        return promoteID;
    }

    public void setPromoteID(int promoteID) {
        this.promoteID = promoteID;
    }

    public int getPromotterID() {
        return promotterID;
    }

    public void setPromotterID(int promotterID) {
        this.promotterID = promotterID;
    }

    public int getTownID() {
        return townID;
    }

    public void setTownID(int townID) {
        this.townID = townID;
    }

    public String getPromotType() {
        return promotType;
    }

    public void setPromotType(String promotType) {
        this.promotType = promotType;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getProDescrip() {
        return proDescrip;
    }

    public void setProDescrip(String proDescrip) {
        this.proDescrip = proDescrip;
    }

    public String getPromFiles() {
        return promFiles;
    }

    public void setPromFiles(String promFiles) {
        this.promFiles = promFiles;
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
