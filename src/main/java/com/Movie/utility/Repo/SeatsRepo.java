package com.Movie.utility.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Movie.utility.Model.Seats;

public interface SeatsRepo extends JpaRepository<Seats, Integer> {

    List<Seats> findByScreenScreenId(int screenId);

}