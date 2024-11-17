package com.bupt.nicetown.pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class User {
    private int userID;
    private String userName;
    //保护用户隐私从我做起！
    @JsonIgnore
    private String password;
    private String userType;
    private String fullName;
    private String documentType;
    private String documentID;
    private String phonenumber;
    private String introduction;
    private Timestamp registTime;
    private Timestamp lastModified;

    public User() {
    }

    public User(int userID, String userName, String password, String userType, String fullName,
                String documentType, String documentID, String phonenumber, String introduction,
                Timestamp registTime, Timestamp lastModified) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.userType = userType;
        this.fullName = fullName;
        this.documentType = documentType;
        this.documentID = documentID;
        this.phonenumber = phonenumber;
        this.introduction = introduction;
        this.registTime = registTime;
        this.lastModified = lastModified;
    }

    //默认的getter方法
    public String getUserName() {
        return userName;
    }

    //给数据库用的getter方法
    public String getUsername() {
        return userName;
    }

}

