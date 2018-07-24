package com.fabio.test.consoftDemo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.test.consoftDemo.model.FornitoreTipo;
import com.fabio.test.consoftDemo.repo.FornitoreTipoRepo;

@Service
public class FornitoreTipoService
{
	@Autowired
	private FornitoreTipoRepo fornTipoRepo;
	
	public List<FornitoreTipo> getAllFornitoreTipo()
	{
		List<FornitoreTipo> fornTipoList = new ArrayList<>();
        this.fornTipoRepo.findAll().forEach(fornTipo -> fornTipoList.add(fornTipo));
        return fornTipoList;
	}
	
	public FornitoreTipo getByTipoFornitore(String tipoFornitore)
	{
		return this.fornTipoRepo.findByTipoFornitore(tipoFornitore);
	}
}
