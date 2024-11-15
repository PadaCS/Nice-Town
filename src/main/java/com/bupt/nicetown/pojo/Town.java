package com.bupt.nicetown.pojo;

public class Town {
    private int townID;
    private String name;
    private String province;
    private String city;

    public Town() {}
    public Town(int townID, String name, String province, String city) {
        this.townID = townID;
        this.name = name;
        this.province = province;
        this.city = city;
    }

    public int getTownID() {
        return townID;
    }

    public void setTownID(int townID) {
        this.townID = townID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
