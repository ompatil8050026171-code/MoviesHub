package com.Movie.utility.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Movie.utility.Model.Theatres;
import com.Movie.utility.Repo.TheatreRepo;

@Service
public class TheatreService {

	@Autowired
	private TheatreRepo theatreRepo;
	
	public void addTheatre(Theatres theatre) {
		
		theatreRepo.save(theatre);
		
	}
	
	public List<Theatres> getAllTheatres()
	{
		 List<Theatres> theatre=theatreRepo.findAll();
		 return theatre;
	}
	
	public Optional<Theatres> getTheatreById(int id)
	{
		
		Optional<Theatres> theatre=theatreRepo.findById(id);
		
		return theatre;
		
	}
	
	public String updateTheatre(int id, Theatres theatre) {

	    if (theatreRepo.findById(id).isPresent()) {

	        Theatres existingTheatre = theatreRepo.findById(id).get();

	        if (theatre.getTheatreName() != null) {

	            existingTheatre.setTheatreName(theatre.getTheatreName());

	        }

	        if (theatre.getAddress() != null) {

	            existingTheatre.setAddress(theatre.getAddress());

	        }

	        if (theatre.getStatus() != null) {

	            existingTheatre.setStatus(theatre.getStatus());

	        }

	        theatreRepo.save(existingTheatre);

	        return "Theatre updated";

	    }

	    return "Theatre not found";

	}
	
	public String deleteTheatre(int id) {

	    if (theatreRepo.findById(id).isPresent()) {

	        Theatres theatre = theatreRepo.findById(id).get();

	        theatreRepo.delete(theatre);

	        return "Theatre deleted";
	    }

	    return "Theatre not found";
	}
	
}
