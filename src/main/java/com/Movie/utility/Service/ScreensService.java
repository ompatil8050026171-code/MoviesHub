package com.Movie.utility.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Movie.utility.Model.Screens;
import com.Movie.utility.Repo.ScreensRepo;

@Service
public class ScreensService {

    @Autowired
    private ScreensRepo screensRepo;

    public void addScreen(Screens screen) {
        screensRepo.save(screen);
    }

    public List<Screens> getAllScreens() {
        return screensRepo.findAll();
    }

    public Optional<Screens> getScreenById(int id) {
        return screensRepo.findById(id);
    }

    
    public List<Screens> getScreensByTheatreId(int theatreId) {
        return screensRepo.findByTheatreTheatreId(theatreId);
    }

    public void updateScreen(int id, Screens screen) {

        if (screensRepo.findById(id).isPresent()) {

            Screens existingScreen = screensRepo.findById(id).get();

            if (screen.getScreenName() != null) {
                existingScreen.setScreenName(screen.getScreenName());
            }

            if (screen.getTheatre() != null) {
                existingScreen.setTheatre(screen.getTheatre());
            }

            screensRepo.save(existingScreen);
        }
    }

    public void deleteScreen(int id) {

        if (screensRepo.findById(id).isPresent()) {

            Screens screen = screensRepo.findById(id).get();

            screensRepo.delete(screen);
        }
    }
}