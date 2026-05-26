package com.unifunec.vendas.models;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Uf {
    //Uf = {coduf, nomeuf, siglauf}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer coduf;
    
    @Column
    private String nomeuf;

    @Column
    private String siglauf;

   


    public Integer getCoduf() {
        return coduf;
    }
    public void setCoduf(Integer coduf) {
        this.coduf = coduf;
    }
    public String getNomeuf() {
        return nomeuf;
    }
    public void setNomeuf(String nomeuf) {
        this.nomeuf = nomeuf;
    }
    public String getSiglauf() {
        return siglauf;
    }
    public void setSiglauf(String siglauf) {
        this.siglauf = siglauf;
    }
    public Uf(Integer coduf, String nomeuf, String siglauf) {
        this.coduf = coduf;
        this.nomeuf = nomeuf;
        this.siglauf = siglauf;
    }
    public Uf() {
    }



}
