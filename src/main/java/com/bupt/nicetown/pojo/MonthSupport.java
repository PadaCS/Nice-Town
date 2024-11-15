package com.bupt.nicetown.pojo;

public class MonthSupport {
    private int month;
    private String area;
    private int townID;
    private String promotType;
    private int promoterNum;
    private int supporterNum;

    // 无参构造器
    public MonthSupport() {}

    // 带参构造器
    public MonthSupport(int month, String area, int townID, String promotType,
                        int promoterNum, int supporterNum) {
        this.month = month;
        this.area = area;
        this.townID = townID;
        this.promotType = promotType;
        this.promoterNum = promoterNum;
        this.supporterNum = supporterNum;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public int getPromoterNum() {
        return promoterNum;
    }

    public void setPromoterNum(int promoterNum) {
        this.promoterNum = promoterNum;
    }

    public int getSupporterNum() {
        return supporterNum;
    }

    public void setSupporterNum(int supporterNum) {
        this.supporterNum = supporterNum;
    }
}
