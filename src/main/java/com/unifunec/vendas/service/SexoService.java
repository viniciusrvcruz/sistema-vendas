package com.unifunec.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifunec.vendas.models.Sexo;
import com.unifunec.vendas.repository.SexoRepository;

@Service
public class SexoService {

    @Autowired
    private SexoRepository sexoRepository;

    SexoService(SexoRepository sexoRepository) {
        this.sexoRepository = sexoRepository;
    }


    public List<Sexo> getAllSexos() {
        return sexoRepository.findAll();
    }

    public Sexo SexoId(Integer id) {
        return sexoRepository.findById(id).get();
    }

    public void apagaSexoId(Integer id) {
        sexoRepository.deleteById(id);
    }

    public Sexo salvaSexo(Sexo sexo) {
        return sexoRepository.save(sexo);
    }

    public Sexo atualizaSexo(Sexo sexo, Integer id) {
        sexo.setCodsexo(id);
        return sexoRepository.save(sexo);
    }

}
