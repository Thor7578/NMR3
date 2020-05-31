package com.example.demo.models;

public class Motorhome {
    private String licensePlate;
    private int ID;
    private String model;
    private int beds;
    private int pricePerDay;
    private boolean cleaned;
    private boolean repaired;
    private Status status;

    public Motorhome(String licensePlate, String model, int beds, int pricePerDay){
        this.licensePlate = licensePlate;
        this.model = model;
        this.beds = beds;
        this.pricePerDay = pricePerDay;
        this.cleaned = true;
        this.repaired = true;
        this.status = Status.ACTIVE;
        this.ID = 0;

    }


    public void setPrice(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public void setCleaned(boolean cleaned) {
        this.cleaned = cleaned;
    }

    public void setRepaired(boolean repaired) {
        this.repaired = repaired;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }
}