package com.fabio.test.consoftDemo.repo;

import com.fabio.test.consoftDemo.model.FornitoreTemp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface FornitoreTempRepo extends CrudRepository<FornitoreTemp, Integer> {  }
