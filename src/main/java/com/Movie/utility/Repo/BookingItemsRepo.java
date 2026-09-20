package com.Movie.utility.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Movie.utility.Model.BookingItems;

public interface BookingItemsRepo extends JpaRepository<BookingItems, Integer> {

    List<BookingItems> findByBookingBookingId(int bookingId);

}