package com.fabio.test.consoftDemo.services;

import com.fabio.test.consoftDemo.model.Fornitore;
import com.fabio.test.consoftDemo.repo.FornitoreRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FornitoreService {

    private FornitoreRepo fornitoreRepo;

    public FornitoreService(FornitoreRepo fornitoreRepo) {
        this.fornitoreRepo = fornitoreRepo;
    }

    public List<Fornitore> getAllFornitori(){
        List<Fornitore> f = new ArrayList<>();
        this.fornitoreRepo.findAll().forEach(fornitore -> f.add(fornitore));
        return f;
    }
}
