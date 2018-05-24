package com.fabio.test.consoftDemo.controllers;

import com.fabio.test.consoftDemo.model.Fornitore;
import com.fabio.test.consoftDemo.services.FornitoreService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FornitoreController {

    private FornitoreService fornitoreServ;

    public FornitoreController(FornitoreService fornitoreServ) {
        this.fornitoreServ = fornitoreServ;
    }

    @GetMapping("/fornitori")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Fornitore> gellAllFornitori() {
        return this.fornitoreServ.getAllFornitori();
    }
}
