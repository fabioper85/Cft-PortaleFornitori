package com.fabio.test.consoftDemo.repo;

import com.fabio.test.consoftDemo.model.Fornitore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornitoreRepo extends CrudRepository<Fornitore, Integer> {}
