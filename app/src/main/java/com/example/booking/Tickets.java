package com.example.booking;

public class Tickets {
    double Single_price = 0;
    double Weekly_price = 0;
    double Monthly_price = 0;

    double Class_price;

    public Tickets() {

    }


    public Tickets(double single_price, double weekly_price, double monthly_price, double class_price) {

        Single_price = single_price;
        Weekly_price = weekly_price;
        Monthly_price = monthly_price;

        Class_price = class_price;
    }

    public double getSingle_price() {
        return Single_price;
    }

    public void setSingle_price(double single_price) {
        Single_price = single_price;
    }

    public double getWeekly_price() {
        return Weekly_price;
    }

    public void setWeekly_price(double weekly_price) {
        Weekly_price = weekly_price;
    }

    public double getMonthly_price() {
        return Monthly_price;
    }

    public void setMonthly_price(double monthly_price) {
        Monthly_price = monthly_price;
    }

    public double getClass_price() {
        return Class_price;
    }

    public void setClass_price(double class_price) {
        Class_price = class_price;
    }
}
