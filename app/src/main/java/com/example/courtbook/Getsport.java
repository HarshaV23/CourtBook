package com.example.courtbook;

public class Getsport {
    private int id;
    private int sportimg;
    private String sportname;

public Getsport(int id, int Sportimg, String Sportname){
    this.id = id;
    sportimg=Sportimg;
    sportname=Sportname;
}
public int getSportimg(){
    return sportimg;
}
public String getSportname(){
    return sportname;
}

}
