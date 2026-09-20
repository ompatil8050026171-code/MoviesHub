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

import com.Movie.utility.Model.Snacks;
import com.Movie.utility.Service.SnacksService;

@RestController
public class SnacksController {

    @Autowired
    private SnacksService snacksService;

    @GetMapping("/addSnacks")
    public void addSnacks(@RequestBody Snacks snacks) {
        snacksService.addSnacks(snacks);
    }

    @GetMapping("/getAllSnacks")
    public List<Snacks> getAllSnacks() {
        return snacksService.getAllSnacks();
    }

    @GetMapping("/getSnacksById/{id}")
    public Optional<Snacks> getSnacksById(@PathVariable int id) {
        return snacksService.getSnacksById(id);
    }

    @PutMapping("/updateSnacks/{id}")
    public void updateSnacks(@PathVariable int id,
                             @RequestBody Snacks snacks) {
        snacksService.updateSnacks(id, snacks);
    }

    @DeleteMapping("/deleteSnacks/{id}")
    public void deleteSnacks(@PathVariable int id) {
        snacksService.deleteSnacks(id);
    }
}