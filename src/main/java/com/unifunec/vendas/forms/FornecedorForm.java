package com.unifunec.vendas.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class FornecedorForm {

    @NotBlank(message = "O nome do fornecedor é obrigatório")
    @Size(max = 120, message = "O nome do fornecedor deve ter no máximo 120 caracteres")
    private String nomefornecedor;

    @NotBlank(message = "O telefone do fornecedor é obrigatório")
    @Size(max = 20, message = "O telefone do fornecedor deve ter no máximo 20 caracteres")
    private String telefonefornecedor;

    @NotBlank(message = "O e-mail do fornecedor é obrigatório")
    @Email(message = "O e-mail informado é inválido")
    @Size(max = 120, message = "O e-mail do fornecedor deve ter no máximo 120 caracteres")
    private String emailfornecedor;

    @NotNull(message = "O código da rua é obrigatório")
    private Integer codrua;

    @NotNull(message = "O código do bairro é obrigatório")
    private Integer codbairro;

    @NotNull(message = "O código do CEP é obrigatório")
    private Integer codcep;

    @NotNull(message = "O código da cidade é obrigatório")
    private Integer codcidade;

    public String getNomefornecedor() {
        return nomefornecedor;
    }

    public void setNomefornecedor(String nomefornecedor) {
        this.nomefornecedor = nomefornecedor;
    }

    public String getTelefonefornecedor() {
        return telefonefornecedor;
    }

    public void setTelefonefornecedor(String telefonefornecedor) {
        this.telefonefornecedor = telefonefornecedor;
    }

    public String getEmailfornecedor() {
        return emailfornecedor;
    }

    public void setEmailfornecedor(String emailfornecedor) {
        this.emailfornecedor = emailfornecedor;
    }

    public Integer getCodrua() {
        return codrua;
    }

    public void setCodrua(Integer codrua) {
        this.codrua = codrua;
    }

    public Integer getCodbairro() {
        return codbairro;
    }

    public void setCodbairro(Integer codbairro) {
        this.codbairro = codbairro;
    }

    public Integer getCodcep() {
        return codcep;
    }

    public void setCodcep(Integer codcep) {
        this.codcep = codcep;
    }

    public Integer getCodcidade() {
        return codcidade;
    }

    public void setCodcidade(Integer codcidade) {
        this.codcidade = codcidade;
    }
}
