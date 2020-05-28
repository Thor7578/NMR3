package com.example.demo.models;

public class Invoice {
    private Order order;
    private double total;
    private boolean paid;
    private Date payDate;
    private Date dueDate;


    public Invoice(Order order, Date dueDate){
        this.order = order;
        this.total = order.getTotalPrice();
        this.dueDate = dueDate;
        this.paid = false;
        this.payDate = null;
    }

    public void sendInvoice(){

    }

    public void sendReminder(){

    }



    //Registers an invoice as paid and the paymentdate.
    public void invoicePaid(int day, int month, int year){
        this.paid = true;
        this.payDate = new Date(day, month, year);
    }
}
