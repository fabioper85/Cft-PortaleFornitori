package com.fabio.test.consoftDemo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fabio.test.consoftDemo.model.FornitoreTipo;

@Repository
public interface FornitoreTipoRepo extends CrudRepository<FornitoreTipo, Integer> {

	public FornitoreTipo findByTipoFornitore(String tipoFornitore);
}
