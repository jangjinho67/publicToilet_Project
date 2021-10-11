package com.inhatc.maptest;

public class Toilet {
    private String name;
    private String address;
    private double latitude;
    private double longitude;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public double getLatitude() { return latitude; }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public double getLongitude() { return longitude; }
}

