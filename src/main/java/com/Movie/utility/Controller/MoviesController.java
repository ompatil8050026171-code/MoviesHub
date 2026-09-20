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

import com.Movie.utility.Model.Movies;
import com.Movie.utility.Service.MoviesService;

@RestController
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @PostMapping("/addMovie")
    public void addMovie(@RequestBody Movies movie) {
        moviesService.addMovie(movie);
    }

    @GetMapping("/getAllMovies")
    public List<Movies> getAllMovies() {
        return moviesService.getAllMovies();
    }

    @GetMapping("/getMovieById/{id}")
    public Optional<Movies> getMovieById(@PathVariable int id) {
        return moviesService.getMovieById(id);
    }

    // Extra method
    @GetMapping("/getMoviesByLanguage/{language}")
    public List<Movies> getMoviesByLanguage(@PathVariable String language) {
        return moviesService.getMoviesByLanguage(language);
    }

    @PutMapping("/updateMovie/{id}")
    public void updateMovie(@PathVariable int id,
                            @RequestBody Movies movie) {
        moviesService.updateMovie(id, movie);
    }

    @DeleteMapping("/deleteMovie/{id}")
    public void deleteMovie(@PathVariable int id) {
        moviesService.deleteMovie(id);
    }
}