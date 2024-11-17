package com.bupt.nicetown.pojo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class Promote {
    private int promoteID;
    private int promotterID;
    private int townID;
    private String promotType;
    private String theme;
    private String proDescrip;
    private String images;
    private String videos;
    private Timestamp createTime;
    private Timestamp lastModified;
    private int status;

    // 无参构造器
    public Promote() {}

    // 带参构造器
    public Promote(int promoteID, int promotterID, int townID, String promotType, String theme,
                   String proDescrip, String images, String videos, Timestamp createTime,
                   Timestamp lastModified, int status) {
        this.promoteID = promoteID;
        this.promotterID = promotterID;
        this.townID = townID;
        this.promotType = promotType;
        this.theme = theme;
        this.proDescrip = proDescrip;
        this.images = images;
        this.videos = videos;
        this.createTime = createTime;
        this.lastModified = lastModified;
        this.status = status;
    }
}
