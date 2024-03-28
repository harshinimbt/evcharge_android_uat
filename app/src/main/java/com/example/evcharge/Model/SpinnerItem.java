package com.example.evcharge.Model;

public class SpinnerItem {
    public SpinnerItem(String days) {
        this.Days = days;
    }

    public String getDays() {
        return Days;
    }

    public void setDays(String days) {
        Days = days;
    }

    private String Days;
}
