package com.Movie.utility.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Movie.utility.Model.User;
import com.Movie.utility.Service.UserService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getAllUser")
	public List<User> getAllUser() {
		
		return userService.getAllUsers();
	}
	
	@GetMapping("/getUserById/{id}")
	public Optional<User> getUserById(@PathVariable int id)
	{
		return userService.getUserById(id);
	}
	
	@PostMapping("/addUser")
	public void addUser(@RequestBody User user)
	{
		userService.addUser(user);
	}
	
	@PutMapping("/updateUser/{id}")
	public void updateUser(@PathVariable int id,
	                       @RequestBody User user,
	                       HttpSession session) {

	    User updatedUser = userService.updateUser(id, user);

	    if (updatedUser != null) {
	        session.setAttribute("user", updatedUser);
	    }
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id)
	{
		return userService.deleteUser(id);
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String email,
	                    @RequestParam String password,
	                    HttpSession session) {

	    Optional<User> user = userService.login(email, password);

	    if (user.isPresent()) {

	        session.setAttribute("user", user.get());

	        return "Login successful";
	    }

	    return "Login failed";
	}
	
	@GetMapping("/logout")
	public void logout(HttpSession session,
	                   HttpServletResponse response) throws IOException {

	    session.invalidate();

	    response.sendRedirect("index.jsp");
	}
}
