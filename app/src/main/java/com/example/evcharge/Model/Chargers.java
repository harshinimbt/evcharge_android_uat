package com.example.evcharge.Model;

public class Chargers {
    public String ConnectorType;
    public String Type;
    public String Price;

    public String getAvailability() {
        return Availability;
    }

    public void setAvailability(String availability) {
        Availability = availability;
    }

    public String Availability;

    public String getConnectorType() {
        return ConnectorType;
    }

    public void setConnectorType(String connectorType) {
        ConnectorType = connectorType;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getKw() {
        return kw;
    }

    public void setKw(String kw) {
        this.kw = kw;
    }

    public String kw;

    public Chargers(String connector, String type, String price, String kw, String availability) {
        this.ConnectorType = connector;
        this.Type = type;
        this.Price = price;
        this.kw = kw;
        this.Availability = availability;
    }
}
