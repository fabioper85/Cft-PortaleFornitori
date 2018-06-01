package com.fabio.test.consoftDemo.services;

import org.springframework.stereotype.Service;

import com.fabio.test.consoftDemo.model.FornitoreTemp;
import com.fabio.test.consoftDemo.repo.FornitoreTempRepo;

@Service
public class FornitoreTempService {

    private FornitoreTempRepo fornTempRepo;

    public FornitoreTempService(FornitoreTempRepo fornTempRepo) {
        this.fornTempRepo = fornTempRepo;
    }

    public void saveFornitoreTemp(FornitoreTemp f){
        this.fornTempRepo.save(f);
    }
}
