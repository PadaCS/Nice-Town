package com.bupt.nicetown.pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;


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

    // Getters and Setters
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Timestamp getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Timestamp registTime) {
        this.registTime = registTime;
    }

    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }






}

