package com.Movie.utility.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Movie.utility.Model.Screens;

public interface ScreensRepo extends JpaRepository<Screens, Integer> {

    List<Screens> findByTheatreTheatreId(int theatreId);

}