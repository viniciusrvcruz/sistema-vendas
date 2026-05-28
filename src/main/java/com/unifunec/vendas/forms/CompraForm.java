package com.unifunec.vendas.forms;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class CompraForm {

    @NotNull(message = "A data da compra é obrigatória")
    @PastOrPresent(message = "A data da compra não pode ser futura")
    private Date datacompra;

    @NotNull(message = "O código do cliente é obrigatório")
    private Integer codclientefk;

    public Integer getCodclientefk() {
        return codclientefk;
    }

    public void setCodclientefk(Integer codclientefk) {
        this.codclientefk = codclientefk;
    }

    public Date getDatacompra() {
        return datacompra;
    }

    public void setDatacompra(Date datacompra) {
        this.datacompra = datacompra;
    }
}
