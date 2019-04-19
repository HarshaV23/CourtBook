package com.example.courtbook;

import java.io.Serializable;
import java.util.Date;

public class Userread  {

    String bid;
    String username;
      String uid;
     String email;
     String cname;
     int myear;
     int month;
     int mday;
     Boolean bstatus;

    public Userread() {
    }

    public Userread(String bid,String username,String uid,String email,String cname,int myear,int month,int mday,Boolean bstatus) {
        this.bid=bid;
        this.username=username;
        this.uid=uid;
        this.email=email;
        this.cname=cname;
        this.myear=myear;
        this.month=month;
        this.mday=mday;
        this.bstatus=bstatus;
    }


    public String getBid() {
        return bid;
    }

    public String getUsername() {
        return username;
    }

    public String getUid() {
        return uid;
    }

    public String getEmail() {
        return email;
    }

    public String getCname() {
        return cname;
    }


    public Boolean getBstatus() {
        return bstatus;
    }

    public int getMyear() {
        return myear;
    }

    public int getMonth() {
        return month;
    }

    public int getMday() {
        return mday;
    }
}
