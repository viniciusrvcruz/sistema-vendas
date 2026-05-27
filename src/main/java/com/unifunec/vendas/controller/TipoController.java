package com.unifunec.vendas.controller;

import com.unifunec.vendas.forms.TipoForm;
import com.unifunec.vendas.models.Tipo;
import com.unifunec.vendas.service.TipoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos")
public class TipoController {
    private final TipoService tipoService;

    public TipoController(TipoService tipoService) {
        this.tipoService = tipoService;
    }

    @GetMapping()
    public List<Tipo> getAllCidades() {
        return tipoService.getAllTipos();
    }

    @GetMapping("/{id}")
    public Tipo getTipoId(@PathVariable Integer id) {
        return this.tipoService.getTipoId(id);
    }

    @PostMapping()
    public Tipo postTipo(@RequestBody TipoForm tipoForm) {
        return this.tipoService.salvaTipo(tipoForm);
    }

    @PutMapping("/{id}")
    public Tipo putTipo(@RequestBody TipoForm tipoForm, @PathVariable Integer id) {
        return this.tipoService.atualizaTipo(tipoForm, id);
    }

    @DeleteMapping("/{id}")
    public void deletaTipoId(@PathVariable Integer id) {
        this.tipoService.apagaTipoId(id);
    }
}
