package com.unifunec.vendas.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Marca {
   // marca = {codmarca, nomemarca} - FAZER 
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codmarca;

    @Column
    private String nomemarca;


   
    public Integer getCodmarca() {
        return codmarca;
    }

    public void setCodmarca(Integer codmarca) {
        this.codmarca = codmarca;
    }

    public String getNomemarca() {
        return nomemarca;
    }

    public void setNomemarca(String nomemarca) {
        this.nomemarca = nomemarca;
    }

    public Marca(Integer codmarca, String nomemarca) {
        this.codmarca = codmarca;
        this.nomemarca = nomemarca;
    }

    public Marca() {
    }

    
}
