package com.perycreep.courierapppizzeria.ui.orders;

public class OrderItem {
    int numder;
    String address;

    public OrderItem(int numder, String address) {
        this.numder = numder;
        this.address = address;
    }

    public int getNumder() {
        return numder;
    }

    public void setNumder(int numder) {
        this.numder = numder;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
