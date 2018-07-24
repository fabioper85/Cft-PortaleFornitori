package com.fabio.test.consoftDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fabio.test.consoftDemo.model.Documento;
import com.fabio.test.consoftDemo.model.FornitoreTipo;
import com.fabio.test.consoftDemo.services.FornitoreTipoService;

@RestController
public class FornitoreTipoController
{
	@Autowired
	private FornitoreTipoService ftService;
	
	@GetMapping("/fornitore/all")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<FornitoreTipo> getAllFornitoreTipo()
	{
		return this.ftService.getAllFornitoreTipo();
	}
	
	@GetMapping("/fornitore/{tf}")
	public FornitoreTipo getByFornitoreTipo(@PathVariable String tf)
	{
		return this.ftService.getByTipoFornitore(tf);
	}
	
	@GetMapping("documenti/{tf}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Documento> getDocsByFornitoreTipo(@PathVariable String tf)
	{
		return this.ftService.getByTipoFornitore(tf).getDocumenti();
	}
}
