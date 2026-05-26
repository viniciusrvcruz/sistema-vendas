package com.unifunec.vendas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifunec.vendas.models.Rua;
import com.unifunec.vendas.service.RuaService;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/ruas")
public class RuaController {
    private final RuaService ruaService;

    public RuaController(RuaService ruaService) {
        this.ruaService = ruaService;
    }

    @GetMapping("")
    public List<Rua> getAllRuas() {
        return ruaService.getAllRuas();
    }

    @GetMapping("/{id}")
    public Rua getRuaId(@PathVariable Integer id) {
        return ruaService.getRuaId(id);
    }

    @DeleteMapping("/{id}")
    public void deletaRuaId(@PathVariable Integer id) {
        ruaService.apagaRuaId(id);
    }

    @PostMapping("")
    public Rua postRua(@RequestBody Rua rua) {
        return ruaService.salvaRua(rua);
    }

    @PutMapping("/{id}")
    @Transactional
    public Rua putRua(@RequestBody Rua rua, @PathVariable Integer id) {
        return ruaService.atualizaRua(rua, id);
    }

}
