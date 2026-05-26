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
public class Fornecedor {
    
    //Fornecedor = {codfornecedor, nomefornecedor, codruafk, codbairrofk, codcepfk,  codcidadefk, telefonefornecedor, emailfornecedor}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codfornecedor;

    @Column
    private String nomefornecedor;

    @Column
    private String telefonefornecedor;

    @Column
    private String emailfornecedor;

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



    public Integer getCodfornecedor() {
        return codfornecedor;
    }

    public void setCodfornecedor(Integer codfornecedor) {
        this.codfornecedor = codfornecedor;
    }

    public String getNomefornecedor() {
        return nomefornecedor;
    }

    public void setNomefornecedor(String nomefornecedor) {
        this.nomefornecedor = nomefornecedor;
    }

    public String getTelefonefornecedor() {
        return telefonefornecedor;
    }

    public void setTelefonefornecedor(String telefonefornecedor) {
        this.telefonefornecedor = telefonefornecedor;
    }

    public String getEmailfornecedor() {
        return emailfornecedor;
    }

    public void setEmailfornecedor(String emailfornecedor) {
        this.emailfornecedor = emailfornecedor;
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

    public Fornecedor(Integer codfornecedor, String nomefornecedor, String telefonefornecedor, String emailfornecedor,
            Rua rua, Bairro bairro, Cep cep, Cidade cidade) {
        this.codfornecedor = codfornecedor;
        this.nomefornecedor = nomefornecedor;
        this.telefonefornecedor = telefonefornecedor;
        this.emailfornecedor = emailfornecedor;
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
    }

    public Fornecedor() {
    }


    
}
