package com.Movie.utility.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="seats")
public class Seats {

	@Id
	@Column(name="seat_id")
	private int seatId;
	
	@Column(name="seat_number")
	private String seatNumber;
	
	@Column(name="seat_type")
	private String seatType;
	
	@ManyToOne
	@JoinColumn(name="screen_id")
	private Screens screen;
	
	@JsonIgnore
	@OneToMany(mappedBy = "seat")
	private List<BookingItems> item;
	
	public Seats() {
	}

	public Seats(int seatId, String seatNumber, String seatType) {
		super();
		this.seatId = seatId;
		this.seatNumber = seatNumber;
		this.seatType = seatType;
	}

	public Seats(String seatNumber, String seatType) {
		super();
		this.seatNumber = seatNumber;
		this.seatType = seatType;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public Screens getScreen() {
		return screen;
	}

	public void setScreen(Screens screen) {
		this.screen = screen;
	}

	public List<BookingItems> getItem() {
		return item;
	}

	public void setItem(List<BookingItems> item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Seats [seatId=" + seatId + ", seatNumber=" + seatNumber + ", seatType=" + seatType + "]";
	}

	
	
	
	
}
