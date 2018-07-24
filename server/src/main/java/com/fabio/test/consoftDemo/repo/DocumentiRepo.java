package com.fabio.test.consoftDemo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fabio.test.consoftDemo.model.Documento;

@Repository
public interface DocumentiRepo extends CrudRepository<Documento, Integer> {

}
