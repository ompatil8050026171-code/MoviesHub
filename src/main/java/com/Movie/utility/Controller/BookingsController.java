package com.Movie.utility.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Movie.utility.Model.BookingRequest;
import com.Movie.utility.Model.Bookings;
import com.Movie.utility.Model.User;
import com.Movie.utility.Service.BookingsService;

import jakarta.servlet.http.HttpSession;

@RestController
public class BookingsController {

    @Autowired
    private BookingsService bookingsService;

    @GetMapping("/addBooking")
    public void addBooking(@RequestBody Bookings booking) {
        bookingsService.addBooking(booking);
    }

    @GetMapping("/getAllBookings")
    public List<Bookings> getAllBookings() {
        return bookingsService.getAllBookings();
    }

    @GetMapping("/getBookingById/{id}")
    public Optional<Bookings> getBookingById(@PathVariable int id) {
        return bookingsService.getBookingById(id);
    }

    // Extra method
    @GetMapping("/getBookingsByUserId/{userId}")
    public List<Bookings> getBookingsByUserId(@PathVariable int userId) {
        return bookingsService.getBookingsByUserId(userId);
    }

    @PutMapping("/updateBooking/{id}")
    public void updateBooking(@PathVariable int id,
                              @RequestBody Bookings booking) {
        bookingsService.updateBooking(id, booking);
    }

    @DeleteMapping("/deleteBooking/{id}")
    public void deleteBooking(@PathVariable int id) {
        bookingsService.deleteBooking(id);
    }
    
    @PostMapping("/confirmBooking")
    public int confirmBooking(
            @RequestBody BookingRequest request,
            HttpSession session) {

        User user = (User) session.getAttribute("user");

        if (user == null) {
            throw new RuntimeException("User not logged in");
        }

        return bookingsService.confirmBooking(request, user);
    }
}