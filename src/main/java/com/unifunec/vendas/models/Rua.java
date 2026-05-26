package com.unifunec.vendas.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Rua {

    //Rua = {codrua, nomerua}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codrua;

    @Column
    private String nomerua;

    public Rua(Integer codrua, String nomerua) {
        this.codrua = codrua;
        this.nomerua = nomerua;
    }



    public Rua() {
    }

    public Integer getCodrua() {
        return codrua;
    }

    public void setCodrua(Integer codrua) {
        this.codrua = codrua;
    }

    public String getNomerua() {
        return nomerua;
    }

    public void setNomerua(String nomerua) {
        this.nomerua = nomerua;
    }

    

  
}
