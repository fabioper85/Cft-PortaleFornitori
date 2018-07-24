package com.fabio.test.consoftDemo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table
public class FornitoreTipo {

    private int id;
    private String tipoFornitore;
    private String descrizione;
    private List<Fornitore> fornitori;
    private List<Documento> documenti;
    
    public FornitoreTipo() {
    	this.documenti = new ArrayList<>();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoFornitore() {
        return tipoFornitore;
    }

    public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public void setTipoFornitore(String tipoFornitore) {
        this.tipoFornitore = tipoFornitore;
    }
    
    @OneToMany(mappedBy = "tipoFornitoreId", cascade = CascadeType.ALL)
    @JsonBackReference
    public Collection<Fornitore> getFornitori() {
        return fornitori;
    }

    public void setFornitori(List<Fornitore> fornitori) {
        this.fornitori = fornitori;
    }
    
    @ManyToMany(mappedBy="tipiFornitore")
	@JsonBackReference
	public List<Documento> getDocumenti() {
		return documenti;
	}

	public void setDocumenti(List<Documento> documenti) {
		this.documenti = documenti;
	}
}
