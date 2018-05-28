package com.fabio.test.consoftDemo.controllers;

import com.fabio.test.consoftDemo.model.FornitoreTemp;
import com.fabio.test.consoftDemo.repo.FornitoreRepo;
import com.fabio.test.consoftDemo.services.FornitoreTempService;
import com.fabio.test.consoftDemo.services.UploadFileService;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Timestamp;
import java.util.Date;

@Controller
public class FornitoreTempController {

    private FornitoreTempService fornTempServ;
    private UploadFileService uploadFileServ;

    public FornitoreTempController(
            FornitoreTempService fornTempServ,
            UploadFileService uploadFileServ)
    {
        this.fornTempServ = fornTempServ;
        this.uploadFileServ = uploadFileServ;
    }

    @PostMapping("/fornitoriTemp")
    @CrossOrigin(origins = "http://localhost:4200")
    public void addFornitoreTemp(
            @RequestParam("ragioneSociale") String ragSoc,
            @RequestParam("sedeLegale") String sedeLegale,
            @RequestParam("sedeOperativa") String sedeOperativa,
            @RequestParam("dataInizioAttività") Date dataInizio,
            @RequestParam("codiceFiscale") String codiceFiscale,
            @RequestParam("partitaIVA") String partitaIVA,
            @RequestParam("telNumero") String telNumero,
            @RequestParam("faxNumero") String faxNumero,
            @RequestParam("email") String email,
            @RequestParam("docs[]") MultipartFile[] files,
            HttpServletResponse response)
    {

        try
        {
            // SAVE TEMP FORNITORE
            FornitoreTemp f = new FornitoreTemp();
            f.setRagioneSociale(ragSoc);
            f.setSedeLegale(sedeLegale);
            f.setSedeOperativa(sedeOperativa);
            f.setDataInizioAttività(dataInizio);
            f.setCodiceFiscale(codiceFiscale);
            f.setPartitaIva(partitaIVA);
            f.setTelefono(telNumero);
            f.setFax(faxNumero);
            f.setEmail(email);
            this.fornTempServ.saveFornitoreTemp(f);

            // SAVE FILES

            this.uploadFileServ.uploadFileToFileSystem(files, partitaIVA);
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept, x-requested-with, Cache-Control");
            response.setStatus(HttpStatus.OK.value());
            response.sendRedirect("http://localhost:4200");;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
