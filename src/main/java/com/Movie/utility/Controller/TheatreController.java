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

import com.Movie.utility.Model.Theatres;
import com.Movie.utility.Service.TheatreService;

@RestController
public class TheatreController {

	@Autowired
	private TheatreService theatreService;
	
	@GetMapping("/addTheatre")
	public void addTheatre(@RequestBody Theatres theatre)
	{
		theatreService.addTheatre(theatre);
	}
	
	@GetMapping("/getAllTheatres")
	public List<Theatres> getAllTheatres()
	{
		return theatreService.getAllTheatres();
	}
	
	@GetMapping("getTheatreById/{id}")
	public Optional<Theatres> getTheatreById(@PathVariable int id)
	{
		return theatreService.getTheatreById(id);
	}
	
	@PutMapping("/updateTheatre/{id}")
	public void updateTheatre(@PathVariable int id, @RequestBody Theatres theatre)
	{
		theatreService.updateTheatre(id,theatre);
	}
	
	@DeleteMapping("/deleteTheatre/{id}")
	public void deleteTheatre(@PathVariable int id)
	{
		theatreService.deleteTheatre(id);
	}
}
