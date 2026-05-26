package com.unifunec.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifunec.vendas.forms.CidadeForm;
import com.unifunec.vendas.models.Cidade;
import com.unifunec.vendas.models.Uf;
import com.unifunec.vendas.repository.CidadeRepository;
import com.unifunec.vendas.repository.UfRepository;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private UfRepository ufRepository;


    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

     public List<Cidade> getAllCidades() {
        return cidadeRepository.findAll();
    }

    public Cidade getCidadeId(Integer id) {
        return cidadeRepository.findById(id).orElse(null);
    }

    public Cidade getNomecidade(String nomecidade) {
        return cidadeRepository.findByNomecidade(nomecidade);
    }

    public void apagaCidadeId(Integer id) {
        cidadeRepository.deleteById(id);
    }
    
     public Cidade salvaCidade(CidadeForm cidadeForm) {
        Cidade cidade = cidadeForm.converter(ufRepository);
        return cidadeRepository.save(cidade);
    }

    public Cidade atualizaCidade(CidadeForm cidadeForm, Integer id) {
        
        Uf uf = ufRepository.findByNomeuf(cidadeForm.getNomeuf());
        Cidade cidade = cidadeRepository.findById(id).orElse(null);
        cidade.setNomecidade(cidadeForm.getNomecidade());
        cidade.setUf(uf);

        return cidade;

    }

}
