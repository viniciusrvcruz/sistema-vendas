package com.unifunec.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.unifunec.vendas.forms.CepForm;
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

    public Cep salvaCep(CepForm cepForm) {
        if (cepRepository.existsByNumerocep(cepForm.getNumerocep())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "CEP já cadastrado");
        }
        Cep cep = cepForm.converter();
        return cepRepository.save(cep);
    }

    public Cep atualizaCep(CepForm cepForm, Integer id) {
        Cep cep = cepRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CEP não encontrado"));

        if (cepRepository.existsByNumerocepAndCodcepNot(cepForm.getNumerocep(), id)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "CEP já cadastrado");
        }

        cep.setNumerocep(cepForm.getNumerocep());
        return cepRepository.save(cep);
    }

}
