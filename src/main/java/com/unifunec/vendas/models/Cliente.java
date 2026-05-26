package com.unifunec.vendas.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cliente {
    //Cliente = {codcliente, nomecliente, codsexofk, codruafk, codbairrofk,  codcepfk, codcidadefk}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codcliente;

    @Column
    private String nomecliente;

    @ManyToOne
    @JoinColumn(name = "codsexofk")
    private Sexo sexo;

    @ManyToOne
    @JoinColumn(name = "codruafk")
    private Rua rua;

    @ManyToOne
    @JoinColumn(name = "codbairrofk")
    private Bairro bairro;

    @ManyToOne
    @JoinColumn(name = "codcepfk")
    private Cep cep;

    @ManyToOne
    @JoinColumn(name = "codcidadefk")
    private Cidade cidade;

    

    public Integer getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(Integer codcliente) {
        this.codcliente = codcliente;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Rua getRua() {
        return rua;
    }

    public void setRua(Rua rua) {
        this.rua = rua;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Cep getCep() {
        return cep;
    }

    public void setCep(Cep cep) {
        this.cep = cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Cliente(Integer codcliente, String nomecliente, Sexo sexo, Rua rua, Bairro bairro, Cep cep, Cidade cidade) {
        this.codcliente = codcliente;
        this.nomecliente = nomecliente;
        this.sexo = sexo;
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
    }

    public Cliente() {
    }


    
}
