package com.perycreep.courierapppizzeria.ui.orders;

public class OrderItem {

    String FIO, address,totalOrder;
    Double totalSumm;
    Boolean paidOnline;

    public OrderItem(String FIO, String address, Double totalSumm, Boolean paidOnline,String totalOrder) {
        this.FIO = FIO;
        this.address = address;
        this.totalOrder = totalOrder;
        this.totalSumm = totalSumm;
        this.paidOnline = paidOnline;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(String totalOrder) {
        this.totalOrder = totalOrder;
    }

    public String getTotalSumm() {
        return totalSumm.toString();
    }

    public void setTotalSumm(Double totalSumm) {
        this.totalSumm = totalSumm;
    }

    public Boolean getPaidOnline() {
        return paidOnline;
    }

    public void setPaidOnline(Boolean paidOnline) {
        this.paidOnline = paidOnline;
    }
}
