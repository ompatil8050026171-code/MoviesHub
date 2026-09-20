package com.Movie.utility.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="booking_items")
public class BookingItems {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_item_id")
	private int bookingItemId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="booking_id")
	private Bookings booking;
	
	@ManyToOne
	@JoinColumn(name="seat_id")
	private Seats seat;
	
	@ManyToOne
	@JoinColumn(name="snack_id")
	private Snacks snack;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="price")
	private double price;
	
	public BookingItems() {
	}

	public BookingItems(int bookingItemId, int quantity, double price) {
		super();
		this.bookingItemId = bookingItemId;
		this.quantity = quantity;
		this.price = price;
	}

	public BookingItems(int quantity, double price) {
		super();
		this.quantity = quantity;
		this.price = price;
	}

	public int getBookingItemId() {
		return bookingItemId;
	}

	public void setBookingItemId(int bookingItemId) {
		this.bookingItemId = bookingItemId;
	}

	public Bookings getBooking() {
		return booking;
	}

	public void setBooking(Bookings booking) {
		this.booking = booking;
	}

	public Seats getSeat() {
		return seat;
	}

	public void setSeat(Seats seat) {
		this.seat = seat;
	}

	public Snacks getSnack() {
		return snack;
	}

	public void setSnack(Snacks snack) {
		this.snack = snack;
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

	@Override
	public String toString() {
		return "BookingItems [bookingItemId=" + bookingItemId + ", quantity=" + quantity + ", price=" + price + "]";
	}

	

	
}
