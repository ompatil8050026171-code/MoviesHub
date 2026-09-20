package com.Movie.utility.Model;

public class SnackRequest {

    private int snackId;
    private int quantity;
    private double price;


    public int getSnackId() {
        return snackId;
    }

    public void setSnackId(int snackId) {
        this.snackId = snackId;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}