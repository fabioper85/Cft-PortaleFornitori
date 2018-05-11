package com.fabio.test.consoftDemo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabio.test.consoftDemo.model.User;
import com.fabio.test.consoftDemo.model.UserLogin;
import com.fabio.test.consoftDemo.repository.LoginRepository;
import com.fabio.test.consoftDemo.repository.UserRepository;

@RestController
public class UserLoginController {
	
	private UserRepository userRepo;

	public UserLoginController(LoginRepository loginRepo, UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	@GetMapping("/login/{vatNum}")
	@CrossOrigin(origins = "http://localhost:4200")
	public boolean getCredentialsByVatNum(@PathVariable String vatNum, String password)
	{
		boolean isVerified = false;
		User user = userRepo.getUserByVatNumber(vatNum);
		UserLogin userLog = user.getLogin();
		if(userLog.getPassword().equals(password))
		{
			isVerified = true;
		}
		
		return isVerified;
	}
	
	@PostMapping("/login/{vatNum}")
	@CrossOrigin(origins = "http://localhost:4200")
	public boolean getCredentialsByVatNumPost(@PathVariable String vatNum, String password)
	{
		boolean isVerified = false;
		User user = userRepo.getUserByVatNumber(vatNum);
		UserLogin userLog = user.getLogin();
		if(userLog.getPassword().equals(password))
		{
			isVerified = true;
		}
		
		return isVerified;
	}
}
