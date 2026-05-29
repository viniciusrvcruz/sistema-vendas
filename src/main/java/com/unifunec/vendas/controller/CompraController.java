package com.unifunec.vendas.controller;

import com.unifunec.vendas.forms.CompraForm;
import com.unifunec.vendas.models.Compra;
import com.unifunec.vendas.service.CompraService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {
    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @GetMapping()
    public List<Compra> getAllCompras() {
        return compraService.getAllCompras();
    }

    @GetMapping("/{id}")
    public Compra getCompraId(@PathVariable Long id) {
        return compraService.getCompraId(id);
    }

    @PostMapping()
    public Compra postCompra(@Valid @RequestBody CompraForm compraForm) {
        return compraService.salvaCompra(compraForm);
    }

    @PutMapping("/{id}")
    @Transactional
    public Compra putCompra(@Valid @RequestBody CompraForm compraForm, @PathVariable Long id) {
        return compraService.atualizaCompra(compraForm, id);
    }

    @DeleteMapping("/{id}")
    public void deletaCompraId(@PathVariable Long id) {
        compraService.apagaCompraId(id);
    }
}
