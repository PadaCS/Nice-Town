package com.bupt.nicetown.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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
}
