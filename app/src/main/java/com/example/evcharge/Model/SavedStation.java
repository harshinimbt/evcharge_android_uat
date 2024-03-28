package com.example.evcharge.Model;

public class SavedStation {

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

    public String StationName;
    public String Address;

    public SavedStation(String name, String address) {
        this.StationName = name;
        this.Address = address;
    }
}
