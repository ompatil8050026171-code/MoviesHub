package com.Movie.utility.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Movie.utility.Model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	 Optional<User> findByEmail(String email);
}
