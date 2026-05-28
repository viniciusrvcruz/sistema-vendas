package com.unifunec.vendas.forms;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ClienteForm {

    private Integer codcliente;

    @NotBlank(message = "O nome do cliente é obrigatório")
    @Size(max = 120, message = "O nome do cliente deve ter no máximo 120 caracteres")
    private String nomecliente;

    @NotNull(message = "O código do sexo é obrigatório")
    private Integer codsexofk;

    @NotNull(message = "O código da rua é obrigatório")
    private Integer codruafk;

    @NotNull(message = "O código do bairro é obrigatório")
    private Integer codbairrofk;

    @NotNull(message = "O código do CEP é obrigatório")
    private Integer codcepfk;

    @NotNull(message = "O código da cidade é obrigatório")
    private Integer codcidadefk;

    public Integer getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(Integer codcliente) {
        this.codcliente = codcliente;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    public Integer getCodsexofk() {
        return codsexofk;
    }

    public void setCodsexofk(Integer codsexofk) {
        this.codsexofk = codsexofk;
    }

    public Integer getCodruafk() {
        return codruafk;
    }

    public void setCodruafk(Integer codruafk) {
        this.codruafk = codruafk;
    }

    public Integer getCodbairrofk() {
        return codbairrofk;
    }

    public void setCodbairrofk(Integer codbairrofk) {
        this.codbairrofk = codbairrofk;
    }

    public Integer getCodcepfk() {
        return codcepfk;
    }

    public void setCodcepfk(Integer codcepfk) {
        this.codcepfk = codcepfk;
    }

    public Integer getCodcidadefk() {
        return codcidadefk;
    }

    public void setCodcidadefk(Integer codcidadefk) {
        this.codcidadefk = codcidadefk;
    }
}
