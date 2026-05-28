package com.unifunec.vendas.forms;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class ProdutoForm {

    @NotBlank(message = "O nome do produto é obrigatório")
    @Size(min = 2, max = 100, message = "O nome do produto deve ter entre 2 e 100 caracteres")
    private String nomeproduto;

    @NotNull(message = "O código do tipo é obrigatório")
    private Integer codtipofk;

    @NotNull(message = "O código da marca é obrigatório")
    private Integer codmarcafk;

    @NotNull(message = "O código do fornecedor é obrigatório")
    private Integer codfornecedorfk;

    @NotNull(message = "A quantidade é obrigatória")
    @PositiveOrZero(message = "A quantidade deve ser zero ou maior")
    private Double quantidade;

    @NotNull(message = "O valor é obrigatório")
    @Positive(message = "O valor deve ser maior que zero")
    private Double valor;

    public String getNomeproduto() {
        return nomeproduto;
    }

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }

    public Integer getCodtipofk() {
        return codtipofk;
    }

    public void setCodtipofk(Integer codtipofk) {
        this.codtipofk = codtipofk;
    }

    public Integer getCodmarcafk() {
        return codmarcafk;
    }

    public void setCodmarcafk(Integer codmarcafk) {
        this.codmarcafk = codmarcafk;
    }

    public Integer getCodfornecedorfk() {
        return codfornecedorfk;
    }

    public void setCodfornecedorfk(Integer codfornecedorfk) {
        this.codfornecedorfk = codfornecedorfk;
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
}
