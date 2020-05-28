package com.example.demo.models;

import java.util.LinkedList;

public class BookKeeperToDoList {
    private static BookKeeperToDoList bookKeeperToDoList = null;

    private LinkedList<Invoice> invoicesToSend;
    private LinkedList<Invoice> remindersToSend;

    private BookKeeperToDoList(){

    }

    public static BookKeeperToDoList getInstance(){
        if(bookKeeperToDoList==null){
            bookKeeperToDoList = new BookKeeperToDoList();
        }
        return bookKeeperToDoList;
    }

    public void addToInvoicesToSend(Invoice invoice){
        invoicesToSend.add(invoice);
    }

    public void addRemindersToSend(Invoice invoice){
        remindersToSend.add(invoice);
    }

    public void rmvFirstElementInvoices(){
        invoicesToSend.remove();
    }

    public void rmvFirstElementReminders(){
        remindersToSend.remove();
    }


}
