package com.fabio.test.consoftDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fabio.test.consoftDemo.model.User;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Integer>{}
