package com.unifunec.vendas.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Bairro {

     //Bairro = {codbairro, nomebairro}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codbairro;

    @Column
    private String nomebairro;

    @OneToMany(mappedBy = "bairro")
    private List<Cliente> clientes;

    public Integer getCodbairro() {
        return codbairro;
    }

    public void setCodbairro(Integer codbairro) {
        this.codbairro = codbairro;
    }

    public String getNomebairro() {
        return nomebairro;
    }

    public void setNomebairro(String nomebairro) {
        this.nomebairro = nomebairro;
    }

    public Bairro(Integer codbairro, String nomebairro) {
        this.codbairro = codbairro;
        this.nomebairro = nomebairro;
    }

    public Bairro() {
    }


    
}
