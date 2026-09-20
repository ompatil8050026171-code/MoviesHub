package com.Movie.utility;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoviesHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesHubApplication.class, args);
		
		System.out.println("Spring boot started");
	}

}
