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
public class Produto {
    //10) Produto = {codproduto, nomeproduto, codtipofk, codmarcafk, quantidade, valor, codfornecedorfk}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codproduto;

    @Column
    private String nomeproduto;

    @ManyToOne
    @JoinColumn(name = "codtipofk")
    private Tipo tipo;

    @ManyToOne
    @JoinColumn(name = "codmarcafk")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "codfornecedorfk")
    private Fornecedor fornecedor;

    @Column
    private Double quantidade;

    @Column
    private Double valor;

    public Long getCodproduto() {
        return codproduto;
    }

    public void setCodproduto(Long codproduto) {
        this.codproduto = codproduto;
    }

    public String getNomeproduto() {
        return nomeproduto;
    }

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Produto(Long codproduto, String nomeproduto, Tipo tipo, Marca marca, Fornecedor fornecedor,
            Double quantidade, Double valor) {
        this.codproduto = codproduto;
        this.nomeproduto = nomeproduto;
        this.tipo = tipo;
        this.marca = marca;
        this.fornecedor = fornecedor;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Produto() {
    }


    
    
}
