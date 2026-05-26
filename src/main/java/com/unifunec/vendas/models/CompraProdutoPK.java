package com.unifunec.vendas.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CompraProdutoPK implements Serializable {

    @Column(name = "codcomprafk")
    private Long codcomprafk;

    @Column(name = "codprodutofk")
    private Long codprodutofk;

    

    public Long getCodcomprafk() {
        return codcomprafk;
    }

    public void setCodcomprafk(Long codcomprafk) {
        this.codcomprafk = codcomprafk;
    }

    public Long getCodprodutofk() {
        return codprodutofk;
    }

    public void setCodprodutofk(Long codprodutofk) {
        this.codprodutofk = codprodutofk;
    }

    // Getters, Setters e Construtores
    public CompraProdutoPK() {}

    public CompraProdutoPK(Long codcomprafk, Long codprodutofk) {
        this.codcomprafk = codcomprafk;
        this.codprodutofk = codprodutofk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompraProdutoPK that = (CompraProdutoPK) o;
        return Objects.equals(codcomprafk, that.codcomprafk) && Objects.equals(codprodutofk, that.codprodutofk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codcomprafk, codprodutofk);
    }

    
    
}
