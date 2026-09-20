package com.Movie.utility.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Movie.utility.Model.User;
import com.Movie.utility.Repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public List<User> getAllUsers() {
		
		List<User> user=userRepo.findAll();
		
		return user;
	}

	public Optional<User> getUserById(int id) {
		
	       Optional<User> user=userRepo.findById(id);
	       return user;
	}

	public void addUser(User user) {
		
		userRepo.save(user);
		
	}

	public User  updateUser(int id, User user) {

	    if (userRepo.findById(id).isPresent()) {

	        User existingUser = userRepo.findById(id).get();

	        if (user.getName() != null) {
	            existingUser.setName(user.getName());
	        }

	        if (user.getEmail() != null) {
	            existingUser.setEmail(user.getEmail());
	        }

	        if (user.getPassword() != null) {
	            existingUser.setPassword(user.getPassword());
	        }

	        if (user.getPhone() != 0) {
	            existingUser.setPhone(user.getPhone());
	        }

	        if (user.getRole() != null) {
	            existingUser.setRole(user.getRole());
	        }

	        return userRepo.save(existingUser);
	    }

	    return null;
	}

	public String deleteUser(int id) {

	    if (userRepo.findById(id).isPresent()) {

	        User user = userRepo.findById(id).get();

	        userRepo.delete(user);

	        return "User deleted";
	    }
	    else {
	        return "User not found";
	    }
	}
	
	public Optional<User> login(String email, String password) {

	    Optional<User> user = userRepo.findByEmail(email);

	    if (user.isPresent()) {

	        if (user.get().getPassword().equals(password)) {
	            return user;
	        }
	    }

	    return Optional.empty();
	}

}
