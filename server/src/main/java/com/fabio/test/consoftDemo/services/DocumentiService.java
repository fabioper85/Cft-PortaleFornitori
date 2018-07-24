package com.fabio.test.consoftDemo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.test.consoftDemo.model.Documento;
import com.fabio.test.consoftDemo.repo.DocumentiRepo;

@Service
public class DocumentiService
{
	@Autowired
	private DocumentiRepo docRepo;
	
	public List<Documento> getAllDocs()
	{
		List<Documento> docs = new ArrayList<>();
        this.docRepo.findAll().forEach(doc -> docs.add(doc));
        return docs;
	}
}
