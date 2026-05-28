package com.unifunec.vendas.service;

import com.unifunec.vendas.forms.CompraForm;
import com.unifunec.vendas.models.Cliente;
import com.unifunec.vendas.models.Compra;
import com.unifunec.vendas.repository.CompraRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CompraService {
    CompraRepository compraRepository;
    ClienteService clienteService;

    public CompraService(
        CompraRepository compraRepository,
        ClienteService clienteService
    ) {
        this.compraRepository = compraRepository;
        this.clienteService = clienteService;
    }

    public List<Compra> getAllCompras() {
        return compraRepository.findAll();
    }

    public Compra getCompraId(Integer id) {
        return compraRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Compra não encontrada"));
    }

    public void apagaCompraId(Integer id) {
        compraRepository.deleteById(id);
    }

    public Compra salvaCompra(CompraForm compraForm) {
        Compra compra = new Compra();

        preencherCompra(compra, compraForm);

        return compraRepository.save(compra);
    }

    public Compra atualizaCompra(CompraForm compraForm, Integer id) {
        Compra compra = getCompraId(id);

        preencherCompra(compra, compraForm);

        return compraRepository.save(compra);
    }

    private void preencherCompra(Compra compra, CompraForm compraForm) {
        Cliente cliente = clienteService.ClienteId(compraForm.getCodclientefk());

        compra.setCliente(cliente);
        compra.setDatacompra(compraForm.getDatacompra());
    }
}
