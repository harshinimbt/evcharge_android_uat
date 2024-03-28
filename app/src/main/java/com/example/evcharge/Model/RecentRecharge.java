package com.example.evcharge.Model;

public class RecentRecharge {
    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getStationName() {
        return StationName;
    }

    public void setStationName(String stationName) {
        StationName = stationName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
    public String Date;
    public String StationName;
    public String Address;
    public String Price;

    public RecentRecharge(String date, String name, String address ,String price ) {
        this.Date = date;
        this.StationName = name;
        this.Address = address;
        this.Price = price;
    }
}
