package com.Movie.utility.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Movie.utility.Model.Shows;

public interface ShowsRepo extends JpaRepository<Shows, Integer> {

    List<Shows> findByMovieMovieId(int movieId);

    List<Shows> findByScreenScreenId(int screenId);

}