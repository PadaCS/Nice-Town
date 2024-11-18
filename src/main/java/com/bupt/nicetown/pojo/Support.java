package com.bupt.nicetown.pojo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class Support {
    private int supportID;
    private int promoteID;
    private int userID;
    private String supDescrip;
    private String images;
    private String videos;
    private Timestamp createTime;
    private Timestamp lastModified;
    private int status;//0：待接受；1：同意；2：拒绝；3：取消

    // 无参构造器
    public Support() {}

    // 带参构造器
    public Support(int supportID, int promoteID, int userID, String supDescrip, String images,
                   String videos, Timestamp createTime, Timestamp lastModified, int status) {
        this.supportID = supportID;
        this.promoteID = promoteID;
        this.userID = userID;
        this.supDescrip = supDescrip;
        this.images = images;
        this.videos = videos;
        this.createTime = createTime;
        this.lastModified = lastModified;
        this.status = status;//0：待接受；1：同意；2：拒绝；3：取消
    }

    @Override
    public String toString() {
        return "Support{" +
                "supportID=" + supportID +
                ", promoteID=" + promoteID +
                ", userID=" + userID +
                ", supDescrip='" + supDescrip + '\'' +
                ", images='" + images + '\'' +
                ", videos='" + videos + '\'' +
                ", createTime=" + createTime +
                ", lastModified=" + lastModified +
                ", status=" + status +
                '}';
    }

}

