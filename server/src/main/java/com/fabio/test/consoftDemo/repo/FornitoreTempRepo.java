package com.fabio.test.consoftDemo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fabio.test.consoftDemo.model.FornitoreTemp;

@RepositoryRestResource
public interface FornitoreTempRepo extends CrudRepository<FornitoreTemp, Integer> {  }
