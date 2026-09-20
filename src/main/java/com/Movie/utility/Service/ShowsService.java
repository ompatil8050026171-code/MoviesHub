package com.Movie.utility.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Movie.utility.Model.Shows;
import com.Movie.utility.Repo.ShowsRepo;

@Service
public class ShowsService {

    @Autowired
    private ShowsRepo showsRepo;

    public void addShow(Shows show) {
        showsRepo.save(show);
    }

    public List<Shows> getAllShows() {
        return showsRepo.findAll();
    }

    public Optional<Shows> getShowById(int id) {
        return showsRepo.findById(id);
    }

    public List<Shows> getShowsByMovieId(int movieId) {
        return showsRepo.findByMovieMovieId(movieId);
    }

    public List<Shows> getShowsByScreenId(int screenId) {
        return showsRepo.findByScreenScreenId(screenId);
    }

    public void updateShow(int id, Shows show) {
    	
    	if (showsRepo.findById(id).isPresent()) {

            Shows existingShow = showsRepo.findById(id).get();

            if (show.getShowDate() != null) {
                existingShow.setShowDate(show.getShowDate());
            }

            if (show.getStartTime() != null) {
                existingShow.setStartTime(show.getStartTime());
            }

            if (show.getEndTime() != null) {
                existingShow.setEndTime(show.getEndTime());
            }

            if (show.getPrice() != 0) {
                existingShow.setPrice(show.getPrice());
            }

            if (show.getStatus() != null) {
                existingShow.setStatus(show.getStatus());
            }

            showsRepo.save(existingShow);
        }
        
    }

    public void deleteShow(int id) {

        if (showsRepo.findById(id).isPresent()) {

            Shows show = showsRepo.findById(id).get();

            showsRepo.delete(show);
        }
    }
}