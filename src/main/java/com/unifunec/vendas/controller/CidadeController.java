package com.unifunec.vendas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifunec.vendas.forms.CidadeForm;
import com.unifunec.vendas.models.Cidade;
import com.unifunec.vendas.service.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {
    private final CidadeService cidadeService;

    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @GetMapping("")
    public List<Cidade> getAllCidades() {
        return cidadeService.getAllCidades();
    }

    @GetMapping("/{id}")
    public Cidade getCidadeId(@PathVariable Integer id) {
        return cidadeService.getCidadeId(id);
    }

    @GetMapping("/nomecidade/{nomecidade}")
    public Cidade getNomecidade(@PathVariable String nomecidade) {
        return cidadeService.getNomecidade(nomecidade);
    }

    @DeleteMapping("/{id}")
    public void deletaCidadeId(@PathVariable Integer id) {
        cidadeService.apagaCidadeId(id);
    }

    @PostMapping("")
    public Cidade postCidade(@RequestBody CidadeForm cidadeForm) {
        return cidadeService.salvaCidade(cidadeForm);
    }   

    @PutMapping("/{id}")
    public Cidade putCidade(@RequestBody CidadeForm cidadeForm, @PathVariable Integer id) {
        return cidadeService.atualizaCidade(cidadeForm, id);
    }
    
}
