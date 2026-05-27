package com.unifunec.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifunec.vendas.models.Marca;
import com.unifunec.vendas.repository.MarcaRepository;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }


    public List<Marca> getAllMarcas() {
        return marcaRepository.findAll();
    }

    public Marca MarcaId(Integer id) {
        return marcaRepository.findById(id).get();
    }

    public void apagaMarcaId(Integer id) {
        marcaRepository.deleteById(id);
    }

    public Marca salvaMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    public Marca atualizaMarca(Marca marca, Integer id) {
        marca.setCodmarca(id);
        return marcaRepository.save(marca);
    }

}
