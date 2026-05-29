package com.unifunec.vendas.service;


import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.unifunec.vendas.forms.CompraProdutoAtualizacaoForm;
import com.unifunec.vendas.forms.CompraProdutoForm;
import com.unifunec.vendas.models.CompraProduto;
import com.unifunec.vendas.models.CompraProdutoPK;
import com.unifunec.vendas.repository.CompraProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompraProdutoService {

    @Autowired
    private CompraProdutoRepository repository;

    @Autowired
    private CompraService compraService;

    @Autowired
    private ProdutoService produtoService;

    @Transactional
    public CompraProduto salvar(CompraProdutoForm form) {
        CompraProdutoPK id = new CompraProdutoPK(form.getCodcomprafk(), form.getCodprodutofk());

        Optional<CompraProduto> itemExistente = repository.findById(id);

        if (itemExistente.isPresent()) {
            CompraProduto itemParaAtualizar = itemExistente.get();
            itemParaAtualizar.setQuantidade(itemParaAtualizar.getQuantidade() + form.getQuantidade());
            itemParaAtualizar.setValorcp(form.getValorcp());
            return repository.save(itemParaAtualizar);
        } else {
            CompraProduto novoItem = new CompraProduto(id, form.getQuantidade(), form.getValorcp());

            novoItem.setCompra(compraService.getCompraId(form.getCodcomprafk()));
            novoItem.setProduto(produtoService.getProdutoId(form.getCodprodutofk()));

            return repository.save(novoItem);
        }
    }

    public List<CompraProduto> listarTodos() {
        return repository.findAll();
    }

    public CompraProduto buscarPorId(Long codCompra, Long codProduto) {
        return repository.findById(new CompraProdutoPK(codCompra, codProduto))
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Item da compra não encontrado"));
    }

    @Transactional
    public CompraProduto atualizar(CompraProdutoAtualizacaoForm form, Long codCompra, Long codProduto) {
        CompraProduto item = buscarPorId(codCompra, codProduto);
        item.setQuantidade(form.getQuantidade());
        item.setValorcp(form.getValorcp());

        return repository.save(item);
    }

    @Transactional
    public void excluir(Long codCompra, Long codProduto) {
        CompraProduto item = buscarPorId(codCompra, codProduto);
        repository.delete(item);
    }
}