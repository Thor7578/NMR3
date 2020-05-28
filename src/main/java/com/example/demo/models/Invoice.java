package com.example.demo.models;

public class Invoice {
    private Order order;
    private double total;
    private Date dueDate;

    public Invoice(Order order, double total, Date dueDate){
        this.order = order;
        this.total = total;
        this.dueDate = dueDate;

    }

    public void sendInvoice(){


    }

}
