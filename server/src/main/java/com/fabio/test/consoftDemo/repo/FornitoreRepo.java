package com.fabio.test.consoftDemo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fabio.test.consoftDemo.model.Fornitore;

@Repository
public interface FornitoreRepo extends CrudRepository<Fornitore, Integer> {
	
	public Fornitore findByVatnum(String vatnum);
}
