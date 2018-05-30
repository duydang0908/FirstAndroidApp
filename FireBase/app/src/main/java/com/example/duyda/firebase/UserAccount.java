package com.example.duyda.firebase;

public class UserAccount {
    String userID;
    String userName;
    String userPass;

    public  UserAccount(){

    }

    public UserAccount(String userID, String userName, String userPass) {
        this.userID = userID;
        this.userName = userName;
        this.userPass = userPass;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPass() {
        return userPass;
    }
}
