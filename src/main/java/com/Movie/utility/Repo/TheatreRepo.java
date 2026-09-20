package com.Movie.utility.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Movie.utility.Model.Theatres;

public interface TheatreRepo extends JpaRepository<Theatres, Integer> {

}
