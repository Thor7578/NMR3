package com.example.demo.models;

public class Extra {
    private String extraName;
    private double extraPrice;

    public Extra(String extraName, double extraPrice){
        this.extraName = extraName;
        this.extraPrice = extraPrice;
    }

    public Extra(){}

    public String getExtraName() {
        return extraName;
    }

    public void setExtraName(String extraName) {
        this.extraName = extraName;
    }

    public double getExtraPrice() {
        return extraPrice;
    }

    public void setExtraPrice(double extraPrice) {
        this.extraPrice = extraPrice;
    }
}
