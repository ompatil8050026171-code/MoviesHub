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

import com.Movie.utility.Model.Screens;
import com.Movie.utility.Service.ScreensService;

@RestController
public class ScreensController {

    @Autowired
    private ScreensService screensService;

    @GetMapping("/addScreen")
    public void addScreen(@RequestBody Screens screen) {
        screensService.addScreen(screen);
    }

    @GetMapping("/getAllScreens")
    public List<Screens> getAllScreens() {
        return screensService.getAllScreens();
    }

    @GetMapping("/getScreenById/{id}")
    public Optional<Screens> getScreenById(@PathVariable int id) {
        return screensService.getScreenById(id);
    }

    // Extra method
    @GetMapping("/getScreensByTheatreId/{theatreId}")
    public List<Screens> getScreensByTheatreId(@PathVariable int theatreId) {
        return screensService.getScreensByTheatreId(theatreId);
    }

    @PutMapping("/updateScreen/{id}")
    public void updateScreen(@PathVariable int id,
                             @RequestBody Screens screen) {
        screensService.updateScreen(id, screen);
    }

    @DeleteMapping("/deleteScreen/{id}")
    public void deleteScreen(@PathVariable int id) {
        screensService.deleteScreen(id);
    }
}