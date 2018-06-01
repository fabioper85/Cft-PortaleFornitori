package com.fabio.test.consoftDemo.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fabio.test.consoftDemo.model.CredenzialiAccesso;
import com.fabio.test.consoftDemo.model.Fornitore;
import com.fabio.test.consoftDemo.services.FornitoreService;
import com.fasterxml.jackson.annotation.JacksonInject;

@RestController
public class FornitoreController {

    private FornitoreService fornitoreServ;

    public FornitoreController(FornitoreService fornitoreServ) {
        this.fornitoreServ = fornitoreServ;
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public boolean validateLogin(
    		@RequestParam("vatnum") String vatnum,
    		@RequestParam("password") String password
    		)
    {
        Fornitore fTemp = fornitoreServ.getFornitoreByVatnum(vatnum);
        String pwdTemp = fTemp.getLogin().getPassword();
        if(pwdTemp.equals(password)) {
        	return true;
        } else {
        	return false;
        }
    }
}
