package com.fabio.test.consoftDemo.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fabio.test.consoftDemo.model.User;
import com.fabio.test.consoftDemo.repository.UserRepository;
import com.google.gson.Gson;

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
    public List<User> allUsers() {
		List<User> users = new ArrayList<>();
        // return userRepo.findAll().stream().collect(Collectors.toList());
		userRepo.findAll().forEach(users::add);
		return users;
    }
	
	@GetMapping("/users/{vatNum}")
	@CrossOrigin(origins = "http://localhost:4200")
    public String getUserByVat(@PathVariable String vatNum) {
		Gson gson = new Gson();
		String json = gson.toJson(userRepo.getUserByVatNumber(vatNum));
		return json;
    }
}
