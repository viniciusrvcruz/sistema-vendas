package com.unifunec.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifunec.vendas.models.Bairro;
import com.unifunec.vendas.repository.BairroRepository;

@Service
public class BairroService {

    @Autowired
    private BairroRepository bairroRepository;

    BairroService(BairroRepository bairroRepository) {
        this.bairroRepository = bairroRepository;
    }


    public List<Bairro> getAllBairros() {
        return bairroRepository.findAll();
    }

    public Bairro BairroId(Integer id) {
        return bairroRepository.findById(id).get();
    }

    public void apagaBairroId(Integer id) {
        bairroRepository.deleteById(id);
    }

    public Bairro salvaBairro(Bairro bairro) {
        return bairroRepository.save(bairro);
    }

    public Bairro atualizaBairro(Bairro bairro, Integer id) {
        bairro.setCodbairro(id);
        return bairroRepository.save(bairro);
    }

}
