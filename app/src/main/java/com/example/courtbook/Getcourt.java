package com.example.courtbook;

public class Getcourt {
    private int id;
    private String courtnm,courtadd;
    private int courtimg;


    public Getcourt(int id, String courtnm, String courtadd, int courtimg) {
        this.id = id;
        this.courtnm = courtnm;
        this.courtadd = courtadd;
        this.courtimg = courtimg;
    }

    public String getCourtnm() {
        return courtnm;
    }

    public String getCourtadd() {
        return courtadd;
    }


    public int getCourtimg() {
        return courtimg;
    }
}
