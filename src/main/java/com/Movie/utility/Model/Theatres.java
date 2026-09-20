package com.Movie.utility.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="theatres")
public class Theatres {
	
	@Id
	@Column(name="theatre_id")
	private int theatreId;
	
	@Column(name="theatre_name")
	private String theatreName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="status")
	private String status;
	
	@JsonIgnore
	@OneToMany(mappedBy = "theatre")
	private List<Screens> screen;
	
	public Theatres() {
	}

	public Theatres(int theatreId, String theatreName, String address, String status) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.address = address;
		this.status = status;
	}

	public Theatres(String theatreName, String address, String status) {
		super();
		this.theatreName = theatreName;
		this.address = address;
		this.status = status;
	}

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Screens> getScreen() {
		return screen;
	}

	public void setScreen(List<Screens> screen) {
		this.screen = screen;
	}

	@Override
	public String toString() {
		return "Theatres [theatreId=" + theatreId + ", theatreName=" + theatreName + ", address=" + address
				+ ", status=" + status + "]";
	}


	
	
	

	
	
	
	

}
