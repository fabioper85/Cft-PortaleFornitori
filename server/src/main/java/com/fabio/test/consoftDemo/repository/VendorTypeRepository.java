package com.fabio.test.consoftDemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.fabio.test.consoftDemo.model.UserType;

public interface UserTypeRepository extends CrudRepository<UserType, Integer>{
	
	public UserType findByUserType(String userType);
}
