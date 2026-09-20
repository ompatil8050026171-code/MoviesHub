package com.Movie.utility.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Movie.utility.Model.Seats;
import com.Movie.utility.Repo.SeatsRepo;

@Service
public class SeatsService {

    @Autowired
    private SeatsRepo seatsRepo;

    public void addSeat(Seats seat) {
        seatsRepo.save(seat);
    }

    public List<Seats> getAllSeats() {
        return seatsRepo.findAll();
    }

    public Optional<Seats> getSeatById(int id) {
        return seatsRepo.findById(id);
    }

    public List<Seats> getSeatsByScreenId(int screenId) {
        return seatsRepo.findByScreenScreenId(screenId);
    }

    public void updateSeat(int id, Seats seat) {

        if (seatsRepo.findById(id).isPresent()) {

            Seats existingSeat = seatsRepo.findById(id).get();

            if (seat.getSeatNumber() != null) {
                existingSeat.setSeatNumber(seat.getSeatNumber());
            }

            if (seat.getSeatType() != null) {
                existingSeat.setSeatType(seat.getSeatType());
            }

            if (seat.getScreen() != null) {
                existingSeat.setScreen(seat.getScreen());
            }

            seatsRepo.save(existingSeat);
        }
    }

    public void deleteSeat(int id) {

        if (seatsRepo.findById(id).isPresent()) {

            Seats seat = seatsRepo.findById(id).get();

            seatsRepo.delete(seat);
        }
    }
}