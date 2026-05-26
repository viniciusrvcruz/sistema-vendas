package com.unifunec.vendas.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cep {
    //Cep = {codcep, numerocep} - FAZER
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codcep;

    @Column
    private String numerocep;

 

    public Integer getCodcep() {
        return codcep;
    }

    public void setCodcep(Integer codcep) {
        this.codcep = codcep;
    }

    public String getNumerocep() {
        return numerocep;
    }

    public void setNumerocep(String numerocep) {
        this.numerocep = numerocep;
    }

    public Cep(Integer codcep, String numerocep) {
        this.codcep = codcep;
        this.numerocep = numerocep;
    }

    public Cep() {
    }

    
}
