package com.unifunec.vendas.service;

import com.unifunec.vendas.forms.CompraForm;
import com.unifunec.vendas.models.Cliente;
import com.unifunec.vendas.models.Compra;
import com.unifunec.vendas.repository.CompraProdutoRepository;
import com.unifunec.vendas.repository.CompraRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CompraService {
    CompraRepository compraRepository;
    CompraProdutoRepository compraProdutoRepository;
    ClienteService clienteService;

    public CompraService(
        CompraRepository compraRepository,
        CompraProdutoRepository compraProdutoRepository,
        ClienteService clienteService
    ) {
        this.compraRepository = compraRepository;
        this.compraProdutoRepository = compraProdutoRepository;
        this.clienteService = clienteService;
    }

    public List<Compra> getAllCompras() {
        return compraRepository.findAll();
    }

    public Compra getCompraId(Long id) {
        return compraRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Compra não encontrada"));
    }

    public void apagaCompraId(Long id) {
        getCompraId(id);

        if (compraProdutoRepository.existsByCompra_Codcompra(id)) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "Não é possível excluir a compra pois existem itens vinculados");
        }

        compraRepository.deleteById(id);
    }

    public Compra salvaCompra(CompraForm compraForm) {
        Compra compra = new Compra();

        preencherCompra(compra, compraForm);

        return compraRepository.save(compra);
    }

    public Compra atualizaCompra(CompraForm compraForm, Long id) {
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
