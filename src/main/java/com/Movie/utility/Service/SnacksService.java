package com.Movie.utility.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Movie.utility.Model.Snacks;
import com.Movie.utility.Repo.SnacksRepo;

@Service
public class SnacksService {

    @Autowired
    private SnacksRepo snacksRepo;

    public void addSnacks(Snacks snacks) {
        snacksRepo.save(snacks);
    }

    public List<Snacks> getAllSnacks() {
        return snacksRepo.findAll();
    }

    public Optional<Snacks> getSnacksById(int id) {
        return snacksRepo.findById(id);
    }

    public void updateSnacks(int id, Snacks snacks) {

        if (snacksRepo.findById(id).isPresent()) {

            Snacks existingSnacks = snacksRepo.findById(id).get();

            if (snacks.getName() != null) {
                existingSnacks.setName(snacks.getName());
            }

            if (snacks.getPrice() != 0) {
                existingSnacks.setPrice(snacks.getPrice());
            }

            if (snacks.getDescription() != null) {
                existingSnacks.setDescription(snacks.getDescription());
            }

            snacksRepo.save(existingSnacks);
        }
    }

    public void deleteSnacks(int id) {

        if (snacksRepo.findById(id).isPresent()) {

            Snacks snacks = snacksRepo.findById(id).get();

            snacksRepo.delete(snacks);
        }
    }
}