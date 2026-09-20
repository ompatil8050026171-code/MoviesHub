package com.Movie.utility.Model;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="movies")
public class Movies {
	
	
	@Id
	@Column(name="movie_id")
	private int movieId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="genre")
	private String genre;
	
	@Column(name="language")
	private String language;
	
	@Column(name="duration")
	private int duration;
	
	@Column(name="realse_date")
	private Timestamp realseDate;
	
	@Column(name="rating")
	private double rating;
	
	@Column(name="image")
	private String image;
	
	@Column(name="status")
	private String status;
	
	@JsonIgnore
	@OneToMany(mappedBy = "movie")
	private List<Shows> show;
	
	public Movies() {

	}
	
	public Movies(int movieId, String title, String description, String genre, String language, int duration,
			Timestamp realseDate, double rating, String image, String status) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.description = description;
		this.genre = genre;
		this.language = language;
		this.duration = duration;
		this.realseDate = realseDate;
		this.rating = rating;
		this.image = image;
		this.status = status;
	}

	public Movies(String title, String description, String genre, String language, int duration, Timestamp realseDate,
			double rating, String image, String status) {
		super();
		this.title = title;
		this.description = description;
		this.genre = genre;
		this.language = language;
		this.duration = duration;
		this.realseDate = realseDate;
		this.rating = rating;
		this.image = image;
		this.status = status;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Timestamp getRealseDate() {
		return realseDate;
	}

	public void setRealseDate(Timestamp realseDate) {
		this.realseDate = realseDate;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Shows> getShow() {
		return show;
	}

	public void setShow(List<Shows> show) {
		this.show = show;
	}

	@Override
	public String toString() {
		return "Movies [movieId=" + movieId + ", title=" + title + ", description=" + description + ", genre=" + genre
				+ ", language=" + language + ", duration=" + duration + ", realseDate=" + realseDate + ", rating="
				+ rating + ", image=" + image + ", status=" + status + "]";
	}

	

	
	
	
	
	
}
