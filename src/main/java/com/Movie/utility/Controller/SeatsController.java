package com.Movie.utility.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Movie.utility.Model.Seats;
import com.Movie.utility.Service.SeatsService;

@RestController
public class SeatsController {

    @Autowired
    private SeatsService seatsService;

    @GetMapping("/addSeat")
    public void addSeat(@RequestBody Seats seat) {
        seatsService.addSeat(seat);
    }

    @GetMapping("/getAllSeats")
    public List<Seats> getAllSeats() {
        return seatsService.getAllSeats();
    }

    @GetMapping("/getSeatById/{id}")
    public Optional<Seats> getSeatById(@PathVariable int id) {
        return seatsService.getSeatById(id);
    }

    // Extra method
    @GetMapping("/getSeatsByScreenId/{screenId}")
    public List<Seats> getSeatsByScreenId(@PathVariable int screenId) {
        return seatsService.getSeatsByScreenId(screenId);
    }

    @PutMapping("/updateSeat/{id}")
    public void updateSeat(@PathVariable int id,
                           @RequestBody Seats seat) {
        seatsService.updateSeat(id, seat);
    }

    @DeleteMapping("/deleteSeat/{id}")
    public void deleteSeat(@PathVariable int id) {
        seatsService.deleteSeat(id);
    }
}