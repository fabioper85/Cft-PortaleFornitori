package com.fabio.test.consoftDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabio.test.consoftDemo.model.Documento;
import com.fabio.test.consoftDemo.services.DocumentiService;

@RestController
public class DocumentiController
{
	@Autowired
	private DocumentiService docService;
	
	@GetMapping("/documenti")
	public List<Documento> getAllDocs()
	{
		return this.docService.getAllDocs();
	}
}
