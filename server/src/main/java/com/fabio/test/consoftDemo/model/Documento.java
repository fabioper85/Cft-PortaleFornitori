package com.fabio.test.consoftDemo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table
public class Documento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String codice;
	
	private String descrizione;
	
	private boolean haScadenza;
	
	@ManyToMany
	@JsonBackReference
	private List<FornitoreTipo> tipiFornitore;
	
	public Documento() {
		this.tipiFornitore = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public boolean isHaScadenza() {
		return haScadenza;
	}

	public void setHaScadenza(boolean haScadenza) {
		this.haScadenza = haScadenza;
	}

	public List<FornitoreTipo> getTipiFornitore() {
		return tipiFornitore;
	}

	public void setTipiFornitore(List<FornitoreTipo> tipiFornitore) {
		this.tipiFornitore = tipiFornitore;
	}
}
