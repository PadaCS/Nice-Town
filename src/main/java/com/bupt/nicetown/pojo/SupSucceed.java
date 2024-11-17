package com.bupt.nicetown.pojo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
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
}
