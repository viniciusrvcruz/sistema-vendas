package com.unifunec.vendas.forms;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class CompraProdutoForm {

    @NotNull(message = "O código da compra é obrigatório")
    private Long codcomprafk;

    @NotNull(message = "O código do produto é obrigatório")
    private Long codprodutofk;

    @NotNull(message = "A quantidade é obrigatória")
    @Positive(message = "A quantidade deve ser maior que zero")
    private Double quantidade;

    @NotNull(message = "O valor é obrigatório")
    @PositiveOrZero(message = "O valor deve ser zero ou maior")
    private Double valorcp;

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

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorcp() {
        return valorcp;
    }

    public void setValorcp(Double valorcp) {
        this.valorcp = valorcp;
    }
}
