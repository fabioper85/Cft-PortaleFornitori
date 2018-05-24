package com.fabio.test.consoftDemo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class FornitoreTipo {

    private int id;
    private String tipoFornitore;
    private List<Fornitore> fornitori;

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

    public void setTipoFornitore(String tipoFornitore) {
        this.tipoFornitore = tipoFornitore;
    }

    @OneToMany(mappedBy = "tipoFornitoreId", cascade = CascadeType.ALL)
    @JsonBackReference
    public List<Fornitore> getFornitori() {
        return fornitori;
    }

    public void setFornitori(List<Fornitore> fornitori) {
        this.fornitori = fornitori;
    }
}
