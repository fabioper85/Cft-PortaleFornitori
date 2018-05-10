package com.fabio.test.consoftDemo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fabio.test.consoftDemo.model.User;
import com.fabio.test.consoftDemo.model.UserLogin;
import com.fabio.test.consoftDemo.repository.LoginRepository;
import com.fabio.test.consoftDemo.repository.UserRepository;
import com.google.gson.Gson;

@RestController
public class UserLoginController {
	
	private UserRepository userRepo;

	public UserLoginController(LoginRepository loginRepo, UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	@GetMapping("/login/{vatNum}/{pwd}")
	@CrossOrigin(origins = "http://localhost:4200")
	public boolean getCredentialsByVatNum(@PathVariable String vatNum, @PathVariable String pwd)
	{
		Gson gson = new Gson();
		User user = userRepo.getUserByVatNumber(vatNum);
		UserLogin userLog = user.getLogin();
		if(userLog.getPassword().equals(pwd))
		{
			return true;
		}
		return false;
	}
}
