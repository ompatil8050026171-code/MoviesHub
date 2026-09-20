package com.Movie.utility.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Movie.utility.Model.Bookings;

public interface BookingsRepo extends JpaRepository<Bookings, Integer> {

    List<Bookings> findByUserUserId(int userId);

}