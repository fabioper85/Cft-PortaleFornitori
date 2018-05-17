package com.fabio.test.consoftDemo.services;

import org.springframework.stereotype.Service;

import java.util.List;

import com.fabio.test.consoftDemo.model.Documents;
import com.fabio.test.consoftDemo.repository.UserTypeRepository;

@Service
public class DocsService {
	
	private UserTypeRepository userTypeRepo;

	public DocsService(UserTypeRepository userTypeRepo) {
		super();
		this.userTypeRepo = userTypeRepo;
	}
	
	public List<Documents> getDocsByUserType(String userType) {
		return userTypeRepo.findByUserType(userType).getDocsList();
	}
}
