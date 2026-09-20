package com.Movie.utility.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Movie.utility.Model.Snacks;

public interface SnacksRepo extends JpaRepository<Snacks, Integer> 
{

}