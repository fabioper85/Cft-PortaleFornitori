package com.fabio.test.consoftDemo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table
public class Fornitore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    @Column
    private String nome;

    @Column
    private String cognome;

    @OneToOne
    @JsonIgnore
    private FornitoreLogin login;

    @ManyToOne
    @JoinColumn(name="tipoFornitore_id")
    @JsonIgnore
    private FornitoreTipo tipoFornitoreId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public FornitoreLogin getLogin() {
        return login;
    }

    public void setLogin(FornitoreLogin login) {
        this.login = login;
    }

    public FornitoreTipo getTipoFornitoreId() {
        return tipoFornitoreId;
    }

    public void setTipoFornitoreId(FornitoreTipo tipoFornitoreId) {
        this.tipoFornitoreId = tipoFornitoreId;
    }
}
