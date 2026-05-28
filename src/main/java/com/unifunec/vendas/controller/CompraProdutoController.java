package com.unifunec.vendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifunec.vendas.forms.CompraProdutoAtualizacaoForm;
import com.unifunec.vendas.forms.CompraProdutoForm;
import com.unifunec.vendas.models.CompraProduto;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import com.unifunec.vendas.service.CompraProdutoService;

@RestController
@RequestMapping("/compra-produto")
public class CompraProdutoController {
    @Autowired
    private CompraProdutoService service;

    @PostMapping
    public ResponseEntity<CompraProduto> adicionarItem(@Valid @RequestBody CompraProdutoForm form) {
        return ResponseEntity.ok(service.salvar(form));
    }

    @GetMapping
    public List<CompraProduto> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{codCompra}/{codProduto}")
    public CompraProduto buscarPorId(
        @PathVariable Long codCompra,
        @PathVariable Long codProduto
    ) {
        return service.buscarPorId(codCompra, codProduto);
    }

    @PutMapping("/{codCompra}/{codProduto}")
    @Transactional
    public CompraProduto atualizar(
        @Valid @RequestBody CompraProdutoAtualizacaoForm form,
        @PathVariable Long codCompra,
        @PathVariable Long codProduto
    ) {
        return service.atualizar(form, codCompra, codProduto);
    }

    @DeleteMapping("/{codCompra}/{codProduto}")
    public void excluir(
        @PathVariable Long codCompra,
        @PathVariable Long codProduto
    ) {
        service.excluir(codCompra, codProduto);
    }
}
