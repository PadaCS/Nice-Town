package com.bupt.nicetown.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
