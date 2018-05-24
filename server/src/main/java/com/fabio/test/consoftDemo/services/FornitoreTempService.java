package com.fabio.test.consoftDemo.services;

import com.fabio.test.consoftDemo.model.FornitoreTemp;
import com.fabio.test.consoftDemo.repo.FornitoreTempRepo;
import org.springframework.stereotype.Service;

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
