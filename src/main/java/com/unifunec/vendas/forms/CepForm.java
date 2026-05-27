package com.unifunec.vendas.forms;

import com.unifunec.vendas.models.Cep;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CepForm {

    private Integer codcep;

    @NotBlank(message = "O número do CEP é obrigatório")
    @Size(min = 8, max = 8, message = "O CEP deve conter exatamente 8 caracteres")
    @Digits(integer = 8, fraction = 0, message = "O CEP deve conter apenas dígitos")
    private String numerocep;

    public Integer getCodcep() {
        return codcep;
    }

    public void setCodcep(Integer codcep) {
        this.codcep = codcep;
    }

    public String getNumerocep() {
        return numerocep;
    }

    public void setNumerocep(String numerocep) {
        this.numerocep = numerocep;
    }

    public Cep converter() {
        return new Cep(codcep, numerocep);
    }
}
