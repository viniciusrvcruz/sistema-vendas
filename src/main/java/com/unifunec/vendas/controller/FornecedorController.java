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

import com.unifunec.vendas.forms.FornecedorForm;
import com.unifunec.vendas.models.Fornecedor;
import com.unifunec.vendas.service.FornecedorService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    private final FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @GetMapping("")
    public List<Fornecedor> getAllFornecedores() {
        return fornecedorService.getAllFornecedores();
    }

    @GetMapping("/{id}")
    public Fornecedor getFornecedorId(@PathVariable Integer id) {
        return fornecedorService.getFornecedorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletaFornecedorId(@PathVariable Integer id) {
        fornecedorService.apagaFornecedorId(id);
    }

    @PostMapping("")
    public Fornecedor postFornecedor(@Valid @RequestBody FornecedorForm fornecedorForm) {
        return fornecedorService.salvaFornecedor(fornecedorForm);
    }

    @PutMapping("/{id}")
    @Transactional
    public Fornecedor putFornecedor(@Valid @RequestBody FornecedorForm fornecedorForm, @PathVariable Integer id) {
        return fornecedorService.atualizaFornecedor(fornecedorForm, id);
    }
}
