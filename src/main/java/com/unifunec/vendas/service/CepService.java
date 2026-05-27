package com.unifunec.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifunec.vendas.models.Cep;
import com.unifunec.vendas.repository.CepRepository;

@Service
public class CepService {

    @Autowired
    private CepRepository cepRepository;

    CepService(CepRepository cepRepository) {
        this.cepRepository = cepRepository;
    }


    public List<Cep> getAllCeps() {
        return cepRepository.findAll();
    }

    public Cep CepId(Integer id) {
        return cepRepository.findById(id).get();
    }

    public void apagaCepId(Integer id) {
        cepRepository.deleteById(id);
    }

    public Cep salvaCep(Cep cep) {
        //TODO: Validar se CEP existe
        //TODO: Validar se CEP possui exatamente 8 dígitos
        return cepRepository.save(cep);
    }

    public Cep atualizaCep(Cep cep, Integer id) {
        //TODO: Validar se CEP existe
        //TODO: Validar se CEP possui exatamente 8 dígitos
        cep.setCodcep(id);
        return cepRepository.save(cep);
    }

}
