package com.example.cnpm_backend.model;


import jakarta.persistence.*;

@Entity
@Table(name="account")
//@Data
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AccountModel {

    @Id
    @Column(name="userID")
    private int userid;

    @Column(name="username")
    private String userName;
    @Column(name="password")
    private String password;

    public AccountModel(int userID, String userName, String password) {
        this.userid = userID;
        this.userName = userName;
        this.password = password;
    }

    public AccountModel() {

    }

    public int getUserID() {
        return userid;
    }

    public void setUserID(int userID) {
        this.userid = userID;
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
}
