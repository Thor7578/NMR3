package com.example.demo.models;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date (int year, int month, int day) throws IllegalArgumentException {
        if(!checkIfValid(day,month,year)){
            throw new IllegalArgumentException();
        }
        this.year = year;
        this.month = month;
        this.day = day;

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public boolean checkIfValid(int day, int month, int year){
        int monthdays = 0;
        if((day < 1) || (day > 31)){
            return false;
        }

        if((month < 1) || (month > 12)){
            return false;
        }

        switch(month){
            case 1:
                monthdays = 31;
                break;
            case 2:
                if(leapYearCheck(year)){
                    monthdays = 29;
                } else {
                    monthdays = 28;
                }
                break;
            case 3:
                monthdays = 31;
                break;
            case 4:
                monthdays = 30;
                break;
            case 5:
                monthdays = 31;
                break;
            case 6:
                monthdays = 30;
                break;
            case 7:
                monthdays = 31;
                break;
            case 8:
                monthdays = 31;
                break;
            case 9:
                monthdays = 30;
                break;
            case 10:
                monthdays = 31;
                break;
            case 11:
                monthdays = 30;
                break;
            case 12:
                monthdays = 31;
                break;
        }

        if(day > monthdays){
            return false;
        }

        return true;
    }

    private boolean leapYearCheck(int year){
        if((year%4)==0){
            if((year%400)==0){
                return true;
            } else if((year%100)==0) {
                return false;
            }
            return true;
        }
        return false;
    }


    public int dateDiff(Date endDate){      // Ufærdig metode, der skal udregne differencen mellem to datoer
        return 1;
    }


}


