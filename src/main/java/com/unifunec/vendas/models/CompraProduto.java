package com.unifunec.vendas.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class CompraProduto {
    @EmbeddedId
    private CompraProdutoPK id;

    @ManyToOne
    @MapsId("codcomprafk") // Refere-se ao nome do atributo na CompraProdutoPK
    @JoinColumn(name = "codcomprafk")
    private Compra compra;

    @ManyToOne
    @MapsId("codprodutofk") // Refere-se ao nome do atributo na CompraProdutoPK
    @JoinColumn(name = "codprodutofk")
    private Produto produto;

    @Column
    private Double quantidade;

    @Column(name = "valorcp")
    private Double valorcp;

    // 1. CONSTRUTOR VAZIO (Indispensável)
    public CompraProduto() {
    }

    // 2. CONSTRUTOR COMPLETO
    // Dica: Use este construtor para facilitar a criação via Service
    public CompraProduto(CompraProdutoPK id, Double quantidade, Double valorcp) {
        this.id = id;
        this.quantidade = quantidade;
        this.valorcp = valorcp;
    }

    // GETTERS E SETTERS
    public CompraProdutoPK getId() { return id; }
    public void setId(CompraProdutoPK id) { this.id = id; }

    public Compra getCompra() { return compra; }
    public void setCompra(Compra compra) { this.compra = compra; }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }

    public Double getQuantidade() { return quantidade; }
    public void setQuantidade(Double quantidade) { this.quantidade = quantidade; }

    public Double getValorcp() { return valorcp; }
    public void setValorcp(Double valorcp) { this.valorcp = valorcp; }
}