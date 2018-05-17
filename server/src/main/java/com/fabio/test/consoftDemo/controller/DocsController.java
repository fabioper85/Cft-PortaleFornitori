package com.fabio.test.consoftDemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fabio.test.consoftDemo.model.Documents;
import com.fabio.test.consoftDemo.services.DocsService;

@RestController
public class DocsController {
	
	private DocsService docsService;

	public DocsController(DocsService docsService) {
		super();
		this.docsService = docsService;
	}

	@GetMapping("/docs/{userType}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Documents> getDocs(@PathVariable String userType) {
		return docsService.getDocsByUserType(userType);
	}
}
