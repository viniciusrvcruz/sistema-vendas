package com.unifunec.vendas.controller;

import com.unifunec.vendas.forms.ProdutoForm;
import com.unifunec.vendas.models.Produto;
import com.unifunec.vendas.service.ProdutoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping()
    public List<Produto> getAllProdutos() {
        return produtoService.getAllProdutos();
    }

    @GetMapping("/{id}")
    public Produto getProdutoId(@PathVariable Long id) {
        return produtoService.getProdutoId(id);
    }

    @PostMapping()
    public Produto postProduto(@Valid @RequestBody ProdutoForm produtoForm) {
        return produtoService.salvaProduto(produtoForm);
    }

    @PutMapping("/{id}")
    @Transactional
    public Produto putProduto(@Valid @RequestBody ProdutoForm produtoForm, @PathVariable Long id) {
        return produtoService.atualizaProduto(produtoForm, id);
    }

    @DeleteMapping("/{id}")
    public void deletaProdutoId(@PathVariable Long id) {
        produtoService.apagaProdutoId(id);
    }
}
