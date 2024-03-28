package com.example.evcharge.Model;

public class ReachableArea {
public String Place;
public  String Direction;
public  String km;

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public String getDirection() {
        return Direction;
    }

    public void setDirection(String direction) {
        Direction = direction;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public ReachableArea(String place, String direction, String km) {
        this.Place = place;
        this.Direction = direction;
        this.km = km;

    }
}
