package com.Movie.utility.Model;

import java.sql.Time;
import java.util.Date;
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
@Table(name="shows")
public class Shows {
	
	
	@Id
	@Column(name="show_id")
	private int showId;
	
	@ManyToOne
	@JoinColumn(name="movie_id")
	private Movies movie;
	
	@ManyToOne
	@JoinColumn(name="screen_id")
	private Screens screen;
	
	@Column(name="show_date")
	private Date showDate;
	
	@Column(name="start_time")
	private Time startTime;
	
	@Column(name="end_time")
	private Time endTime;
	
	@Column(name="price")
	private double price;
	
	@Column(name="status")
	private String status;
	
	@JsonIgnore
	@OneToMany(mappedBy = "show")
	private List<Bookings> booking;
	
	public Shows() {
	}

	public Shows(int showId, Date showDate, Time startTime, Time endTime, double price, String status) {
		super();
		this.showId = showId;
		this.showDate = showDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.price = price;
		this.status = status;
	}

	public Shows(Date showDate, Time startTime, Time endTime, double price, String status) {
		super();
		this.showDate = showDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.price = price;
		this.status = status;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public Movies getMovie() {
		return movie;
	}

	public void setMovie(Movies movie) {
		this.movie = movie;
	}

	public Screens getScreen() {
		return screen;
	}

	public void setScreen(Screens screen) {
		this.screen = screen;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Shows [showId=" + showId + ", showDate=" + showDate + ", startTime=" + startTime + ", endTime="
				+ endTime + ", price=" + price + ", status=" + status + "]";
	}

	
	
}
