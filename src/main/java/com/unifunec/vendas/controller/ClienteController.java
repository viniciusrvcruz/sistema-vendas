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

import com.unifunec.vendas.forms.ClienteForm;
import com.unifunec.vendas.models.Cliente;
import com.unifunec.vendas.service.ClienteService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("")
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{id}")
    public Cliente getClienteId(@PathVariable Integer id) {
        return clienteService.ClienteId(id);
    }

    @DeleteMapping("/{id}")
    public void deletaClienteId(@PathVariable Integer id) {
        clienteService.apagaClienteId(id);
    }

    @PostMapping("")
    public Cliente postCliente(@Valid @RequestBody ClienteForm clienteForm) {
        return clienteService.salvaCliente(clienteForm);
    }

    @PutMapping("/{id}")
    @Transactional
    public Cliente putCliente(@Valid @RequestBody ClienteForm clienteForm, @PathVariable Integer id) {
        return clienteService.atualizaCliente(clienteForm, id);
    }
}
