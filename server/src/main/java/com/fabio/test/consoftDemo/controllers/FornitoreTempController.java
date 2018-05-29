package com.fabio.test.consoftDemo.controllers;

import com.fabio.test.consoftDemo.model.FornitoreTemp;
import com.fabio.test.consoftDemo.services.FornitoreTempService;
import com.fabio.test.consoftDemo.services.UploadFileService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

import java.util.Date;

@RestController
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
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        response.setStatus(HttpStatus.OK.value());
    }
}
