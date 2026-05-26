package com.unifunec.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifunec.vendas.models.Rua;
import com.unifunec.vendas.repository.RuaRepository;

@Service
public class RuaService {

    @Autowired
    private RuaRepository ruaRepository;

    public RuaService(RuaRepository ruaRepository) {
        this.ruaRepository = ruaRepository;
    }

    public List<Rua> getAllRuas() {
        return ruaRepository.findAll();
    }

    public Rua getRuaId(Integer id) {
        return ruaRepository.findById(id).orElse(null);
    }

    public void apagaRuaId(Integer id) {
        ruaRepository.deleteById(id);
    }

    public Rua salvaRua(Rua rua) {
        return ruaRepository.save(rua);
    }

    public Rua atualizaRua(Rua rua, Integer id) {
        rua.setCodrua(id);
        return ruaRepository.save(rua);
    }

}
