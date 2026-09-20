package com.Movie.utility.Model;

import java.util.List;

public class BookingRequest {

    private int showId;
    private double grandTotal;

    private List<SeatRequest> seats;
    private List<SnackRequest> snacks;


    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }


    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }


    public List<SeatRequest> getSeats() {
        return seats;
    }

    public void setSeats(List<SeatRequest> seats) {
        this.seats = seats;
    }


    public List<SnackRequest> getSnacks() {
        return snacks;
    }

    public void setSnacks(List<SnackRequest> snacks) {
        this.snacks = snacks;
    }
}