package com.fabio.test.consoftDemo.repository;

import org.springframework.data.repository.CrudRepository;
import com.fabio.test.consoftDemo.model.Documents;

public interface DocumentRepository extends CrudRepository<Documents, Integer>{}
