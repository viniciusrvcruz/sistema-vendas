package com.unifunec.vendas.forms;

import com.unifunec.vendas.models.Tipo;

public class TipoForm {
    private String nometipo;

    public String getNometipo() {
        return nometipo;
    }

    public void setNometipo(String nometipo) {
        this.nometipo = nometipo;
    }

    public Tipo converter() {
        return new Tipo(this.nometipo);
    }
}
