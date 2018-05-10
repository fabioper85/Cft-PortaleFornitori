package com.fabio.test.consoftDemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fabio.test.consoftDemo.model.User;
import com.fabio.test.consoftDemo.model.UserLogin;

@RepositoryRestResource
public interface LoginRepository extends CrudRepository<UserLogin, Integer>{
	
	public UserLogin getLoginByUser(User user);
}
