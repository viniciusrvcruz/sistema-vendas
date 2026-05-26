package com.unifunec.vendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifunec.vendas.models.CompraProduto;
import com.unifunec.vendas.service.CompraProdutoService;

@RestController
@RequestMapping("/compra-produto")
public class CompraProdutoController {
    @Autowired
    private CompraProdutoService service;

    @PostMapping
    public ResponseEntity<CompraProduto> adicionarItem(@RequestBody CompraProduto item) {
        return ResponseEntity.ok(service.salvar(item));
    }

    @GetMapping
    public List<CompraProduto> listar() {
        return service.listarTodos();
    }
}
