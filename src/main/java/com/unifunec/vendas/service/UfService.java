package com.unifunec.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifunec.vendas.models.Uf;
import com.unifunec.vendas.repository.UfRepository;



@Service
public class UfService {
    @Autowired
    private UfRepository ufRepository;

    public UfService(UfRepository ufRepository) {
        this.ufRepository = ufRepository;
    }

    public List<Uf> getAllUfs() {
        return ufRepository.findAll();
    }

    public Uf getUfId(Integer id) {
        return ufRepository.findById(id).orElse(null);
    }

    public void apagaUfId(Integer id) {
        ufRepository.deleteById(id);
    }

    public Uf salvaUf(Uf uf) {
        return ufRepository.save(uf);
    }

    public Uf atualizaUf(Uf uf, Integer id) {
        uf.setCoduf(id);
        return ufRepository.save(uf);
    }
}
