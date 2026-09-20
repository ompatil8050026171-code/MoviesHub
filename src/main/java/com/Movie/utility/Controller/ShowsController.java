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

import com.Movie.utility.Model.Shows;
import com.Movie.utility.Service.ShowsService;

@RestController
public class ShowsController {

    @Autowired
    private ShowsService showsService;

    @GetMapping("/addShow")
    public void addShow(@RequestBody Shows show) {
        showsService.addShow(show);
    }

    @GetMapping("/getAllShows")
    public List<Shows> getAllShows() {
        return showsService.getAllShows();
    }

    @GetMapping("/getShowById/{id}")
    public Optional<Shows> getShowById(@PathVariable int id) {
        return showsService.getShowById(id);
    }

    @GetMapping("/getShowsByMovieId/{movieId}")
    public List<Shows> getShowsByMovieId(@PathVariable int movieId) {
        return showsService.getShowsByMovieId(movieId);
    }

    @GetMapping("/getShowsByScreenId/{screenId}")
    public List<Shows> getShowsByScreenId(@PathVariable int screenId) {
        return showsService.getShowsByScreenId(screenId);
    }

    @PutMapping("/updateShow/{id}")
    public void updateShow(@PathVariable int id,
                           @RequestBody Shows show) {
        showsService.updateShow(id, show);
    }

    @DeleteMapping("/deleteShow/{id}")
    public void deleteShow(@PathVariable int id) {
        showsService.deleteShow(id);
    }
}