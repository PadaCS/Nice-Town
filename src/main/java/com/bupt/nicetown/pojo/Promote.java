package com.bupt.nicetown.pojo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class Promote {
    private int promoteID;//自动生成
    private int promotterID;//解析token获取
    private int townID;
    private String promoteType;
    private String theme;
    private String description;
    private String images;
    private String videos;
    private Timestamp createTime;
    private Timestamp lastModified;
    private int status;

    // 无参构造器
    public Promote() {}

    // 带参构造器
    public Promote(int promoteID, int promotterID, int townID, String promotType, String theme,
                   String description, String images, String videos, Timestamp createTime,
                   Timestamp lastModified, int status) {
        this.promoteID = promoteID;
        this.promotterID = promotterID;
        this.townID = townID;
        this.promoteType = promotType;//农家院、自然风光秀丽、古建筑、土特产、特色小吃、民俗活动等
        this.theme = theme;
        this.description = description;
        this.images = images;
        this.videos = videos;
        this.createTime = createTime;
        this.lastModified = lastModified;
        this.status = status;//0：已发布；-1：已取消
    }

    @Override
    public String toString() {
        return "Promote{" +
                "promoteID=" + promoteID +
                ", promotterID=" + promotterID +
                ", townID=" + townID +
                ", promoteType='" + promoteType + '\'' +
                ", theme='" + theme + '\'' +
                ", description='" + description + '\'' +
                ", images='" + images + '\'' +
                ", videos='" + videos + '\'' +
                ", createTime=" + createTime +
                ", lastModified=" + lastModified +
                ", status=" + status +
                '}';
    }
}
