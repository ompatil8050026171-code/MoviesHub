package com.Movie.utility.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Movie.utility.Model.Movies;

public interface MoviesRepo extends JpaRepository<Movies, Integer> {

    List<Movies> findByLanguage(String language);

}