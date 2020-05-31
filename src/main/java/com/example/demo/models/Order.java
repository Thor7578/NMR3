package com.example.demo.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    private Season season;
    private ArrayList<Motorhome>motorhomesInOrder;
    private Extras extras;
    private Location dropOffLocation;
    private double dropOffPrice;
    private double totalPrice;
    private Date startDate;
    private Date endDate;
    private MaintenanceToDoList mTDL;


    public Order(Season season, Date startDate, Date endDate) {
        this.season = season;
        this.motorhomesInOrder = new ArrayList<Motorhome>();
        this.extras = new Extras(0,0,0,0,0);
        this.dropOffPrice = 0.0;
        this.totalPrice = 0.0;
        this.dropOffLocation = null;
        this.startDate = startDate;
        this.endDate = endDate;
        this.mTDL = MaintenanceToDoList.getInstance();

    }

    public void addMotorhomeToOrder (Motorhome motorhome) {

        motorhomesInOrder.add(motorhome);

    }

    public void addExtrasToOrder (int bikeRack, int bedLinen, int childSeat, int picnicTable, int chair) {
        extras.setBikeRack(bikeRack);
        extras.setBedLinen(bedLinen);
        extras.setChildSeat(childSeat);
        extras.setPicnicTable(picnicTable);
        extras.setChair(chair);
    }

    //Drop-offs indicate the final step of an order. When this is finalized an invoice is made and queued at the bookkeeper.

    public void externalDropOffLocation(String cityName, String streetName, String streetNo, int ZIPCode) {
        this.dropOffLocation = new Location(cityName, streetName, streetNo, ZIPCode);
    }

    public void internalDropOffLocation(){
        dropOffPrice = 0;
        for (Motorhome m : motorhomesInOrder){
            mTDL.addMotorhomeToLists(m);
        }
        makeInvoice();
    }

    private void makeInvoice(){
        LocalDate currentDate = LocalDate.now();
        Invoice invoice = new Invoice(this);

        BookkeeperToDoList BTDL = BookkeeperToDoList.getInstance();
        BTDL.addRemindersToSend(invoice);
    }


    public double getTotalPrice() {
        return totalPrice;
    }

    public void setDropOffPrice(double dropOffPrice) {
        this.dropOffPrice = dropOffPrice;
    }

    public void calcTotal(){

    }


}
