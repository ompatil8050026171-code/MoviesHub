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
@Table(name="screens")
public class Screens {
	
	@Id
	@Column(name="screen_id")
	private int screenId;
	
	@Column(name="screen_name")
	private String screenName; 
	
	@ManyToOne
	@JoinColumn(name="theatre_id")
	private Theatres theatre;
	
	@JsonIgnore
	@OneToMany(mappedBy="screen")
	private List<Seats> seat;
	
	@JsonIgnore
	@OneToMany(mappedBy = "screen")
	private List<Shows> show;
	
	
	public Screens() {
	}

	public Screens(int screenId, String screenName) {
		super();
		this.screenId = screenId;
		this.screenName = screenName;
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public Theatres getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatres theatre) {
		this.theatre = theatre;
	}
	
	

	public List<Seats> getSeat() {
		return seat;
	}

	public void setSeat(List<Seats> seat) {
		this.seat = seat;
	}

	public List<Shows> getShow() {
		return show;
	}

	public void setShow(List<Shows> show) {
		this.show = show;
	}

	@Override
	public String toString() {
		return "Screens [screenId=" + screenId + ", screenName=" + screenName + "]";
	}

	
	
	
	

}
