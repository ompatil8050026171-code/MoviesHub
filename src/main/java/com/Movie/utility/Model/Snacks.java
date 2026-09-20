package com.Movie.utility.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="snacks")
public class Snacks {

	@Id
	@Column(name="snack_id")
	private int snackId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private double price;
	
	@Column(name="category")
	private String category;
	
	@Column(name="image")
	private String image;
	
	@Column(name="available")
	private String available;
	
	@JsonIgnore
	@OneToMany(mappedBy = "snack")
	private List<BookingItems> items;
	
	public Snacks() {
		
	}

	public Snacks(int snackId, String name, String description, double price, String category, String image,
			String available) {
		super();
		this.snackId = snackId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.image = image;
		this.available = available;
	}

	public Snacks(String name, String description, double price, String category, String image, String available) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.image = image;
		this.available = available;
	}

	public int getSnackId() {
		return snackId;
	}

	public void setSnackId(int snackId) {
		this.snackId = snackId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public List<BookingItems> getItems() {
		return items;
	}

	public void setItems(List<BookingItems> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Snacks [snackId=" + snackId + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", category=" + category + ", image=" + image + ", available=" + available + "]";
	}

	

	
	
	
}
