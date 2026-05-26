package com.unifunec.vendas.models;

import java.sql.Date;

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
public class Compra {
    //11) Compra = {codcompra, datacompra, codclientefk}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codcompra;

    @Column
    private Date datacompra;

    
    @ManyToOne
    @JoinColumn(name = "codclientefk")
    private Cliente cliente;


    public Long getCodcompra() {
        return codcompra;
    }


    public void setCodcompra(Long codcompra) {
        this.codcompra = codcompra;
    }


    public Date getDatacompra() {
        return datacompra;
    }


    public void setDatacompra(Date datacompra) {
        this.datacompra = datacompra;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public Compra(Long codcompra, Date datacompra, Cliente cliente) {
        this.codcompra = codcompra;
        this.datacompra = datacompra;
        this.cliente = cliente;
    }


    public Compra() {
    }

    
}
