package com.fabio.test.consoftDemo.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
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
    public Collection<User> allUsers() {
        return userRepo.findAll().stream().collect(Collectors.toList());
    }
	
	@GetMapping("/users/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
    public String getUser(@PathVariable String id) {
		Gson gson = new Gson();
        String json = gson.toJson(userRepo.findById(Integer.parseInt(id)).get());
        return json;
    }
}
