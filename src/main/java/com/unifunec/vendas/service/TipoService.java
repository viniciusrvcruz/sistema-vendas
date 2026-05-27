package com.unifunec.vendas.service;

import com.unifunec.vendas.forms.TipoForm;
import com.unifunec.vendas.models.Tipo;
import com.unifunec.vendas.repository.TipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoService {
    private TipoRepository tipoRepository;

    public TipoService(TipoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    public List<Tipo> getAllTipos() {
        return tipoRepository.findAll();
    }

    public Tipo getTipoId(Integer id) {
        return tipoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tipo não encontrado"));
    }

    public void apagaTipoId(Integer id) {
        tipoRepository.deleteById(id);
    }

    public Tipo salvaTipo(TipoForm tipoForm) {
        Tipo tipo = tipoForm.converter();

        return tipoRepository.save(tipo);
    }

    public Tipo atualizaTipo(TipoForm tipoForm, Integer id) {
        Tipo tipo = getTipoId(id);

        tipo.setNometipo(tipoForm.getNometipo());

        return tipoRepository.save(tipo);
    }
}
