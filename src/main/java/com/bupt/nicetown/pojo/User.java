package com.bupt.nicetown.pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class User {
    private int userID;
    private String username;
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

    public User(int userID, String username, String password, String userType, String fullName,
                String documentType, String documentID, String phonenumber, String introduction,
                Timestamp registTime, Timestamp lastModified) {
        this.userID = userID;
        this.username = username;
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

}

