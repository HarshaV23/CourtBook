package com.example.courtbook;

public class Selection {
    public static void setSport(String sport) {
        Selection.sport = sport;
    }

    public static void setCourt(String court) {
        Selection.court = court;
    }

    public static String getSport() {
        return sport;
    }

    public static String getCourt() {
        return court;
    }

    static String sport;
    static String court;



}
