package com.Movie.utility.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Movie.utility.Model.Movies;
import com.Movie.utility.Repo.MoviesRepo;

@Service
public class MoviesService {

    @Autowired
    private MoviesRepo moviesRepo;

    public void addMovie(Movies movie) {
        moviesRepo.save(movie);
    }

    public List<Movies> getAllMovies() {
        return moviesRepo.findAll();
    }

    public Optional<Movies> getMovieById(int id) {
        return moviesRepo.findById(id);
    }

   
    public List<Movies> getMoviesByLanguage(String language) {
        return moviesRepo.findByLanguage(language);
    }

    public void updateMovie(int id, Movies movie) {

        if (moviesRepo.findById(id).isPresent()) {

            Movies existingMovie = moviesRepo.findById(id).get();

            if (movie.getTitle() != null) {
                existingMovie.setTitle(movie.getTitle());
            }

            if (movie.getDescription() != null) {
                existingMovie.setDescription(movie.getDescription());
            }

            if (movie.getGenre() != null) {
                existingMovie.setGenre(movie.getGenre());
            }

            if (movie.getLanguage() != null) {
                existingMovie.setLanguage(movie.getLanguage());
            }

            if (movie.getDuration() != 0) {
                existingMovie.setDuration(movie.getDuration());
            }

            if (movie.getRealseDate() != null) {
                existingMovie.setRealseDate(movie.getRealseDate());
            }

            if (movie.getRating() != 0) {
                existingMovie.setRating(movie.getRating());
            }

            if (movie.getImage() != null) {
                existingMovie.setImage(movie.getImage());
            }

            if (movie.getStatus() != null) {
                existingMovie.setStatus(movie.getStatus());
            }

            moviesRepo.save(existingMovie);
        }
    }

    public void deleteMovie(int id) {

        if (moviesRepo.findById(id).isPresent()) {

            Movies movie = moviesRepo.findById(id).get();

            moviesRepo.delete(movie);
        }
    }
}