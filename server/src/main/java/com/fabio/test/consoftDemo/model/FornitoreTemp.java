package com.fabio.test.consoftDemo.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="fornitoreDaAccreditare")
public class FornitoreTemp {

    private int id;
    private String ragioneSociale;
    private String sedeLegale;
    private String sedeOperativa;
    private Date dataInizioAttività;
    private String partitaIva;
    private String codiceFiscale;
    private String telefono;
    private String fax;
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public String getSedeLegale() {
        return sedeLegale;
    }

    public void setSedeLegale(String sedeLegale) {
        this.sedeLegale = sedeLegale;
    }

    public String getSedeOperativa() {
        return sedeOperativa;
    }

    public void setSedeOperativa(String sedeOperativa) {
        this.sedeOperativa = sedeOperativa;
    }

    public Date getDataInizioAttività() {
        return dataInizioAttività;
    }

    public void setDataInizioAttività(Date dataInizioAttività) {
        this.dataInizioAttività = dataInizioAttività;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    @Size(max=16)
    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FornitoreTemp)) return false;
        FornitoreTemp that = (FornitoreTemp) o;
        return getId() == that.getId() &&
                Objects.equals(getRagioneSociale(), that.getRagioneSociale()) &&
                Objects.equals(getSedeLegale(), that.getSedeLegale()) &&
                Objects.equals(getSedeOperativa(), that.getSedeOperativa()) &&
                Objects.equals(getDataInizioAttività(), that.getDataInizioAttività()) &&
                Objects.equals(getPartitaIva(), that.getPartitaIva()) &&
                Objects.equals(getCodiceFiscale(), that.getCodiceFiscale()) &&
                Objects.equals(getTelefono(), that.getTelefono()) &&
                Objects.equals(getFax(), that.getFax()) &&
                Objects.equals(getEmail(), that.getEmail());
    }
}
