package com.fabio.test.consoftDemo.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabio.test.consoftDemo.model.User;
import com.fabio.test.consoftDemo.repository.UserRepository;

@RestController
public class UserController
{
	private UserRepository userRepo;
	
	public UserController(UserRepository userRepo)
	{
		this.userRepo = userRepo;
	}
	
	@GetMapping("/users")
	@CrossOrigin(origins = "http://localhost:4200")
    public Collection<User> allUsers() {
        return userRepo.findAll().stream().collect(Collectors.toList());
    }
}
