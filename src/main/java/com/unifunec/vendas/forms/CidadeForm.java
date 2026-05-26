package com.unifunec.vendas.forms;

import com.unifunec.vendas.models.Cidade;
import com.unifunec.vendas.models.Uf;
import com.unifunec.vendas.repository.UfRepository;

public class CidadeForm {

    private Integer codcidade;
    private String nomecidade;
    private String nomeuf;


    public Integer getCodcidade() {
        return codcidade;
    }
    public void setCodcidade(Integer codcidade) {
        this.codcidade = codcidade;
    }
    public String getNomecidade() {
        return nomecidade;
    }
    public void setNomecidade(String nomecidade) {
        this.nomecidade = nomecidade;
    }
    public String getNomeuf() {
        return nomeuf;
    }
    public void setNomeuf(String nomeuf) {
        this.nomeuf = nomeuf;
    }

    //método para conversão para a entidade cidade
    public Cidade converter(UfRepository ufRepository) 
    {
        Uf uf = ufRepository.findByNomeuf(nomeuf);

        return new Cidade(nomecidade, uf);
    }



}
