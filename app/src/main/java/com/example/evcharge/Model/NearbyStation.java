package com.example.evcharge.Model;

public class NearbyStation {
    public String StationName;

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

    public String getKms() {
        return Kms;
    }

    public void setKms(String kms) {
        Kms = kms;
    }

    public String Address;
    public String Kms;

    public NearbyStation(String name, String address, String km) {
        this.StationName = name;
        this.Address = address;
        this.Kms = km;
    }
}
