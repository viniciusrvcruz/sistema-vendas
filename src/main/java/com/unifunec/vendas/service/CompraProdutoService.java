package com.unifunec.vendas.service;


import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifunec.vendas.models.Compra;
import com.unifunec.vendas.models.CompraProduto;
import com.unifunec.vendas.models.Produto;
import com.unifunec.vendas.repository.CompraProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompraProdutoService {

    @Autowired
    private CompraProdutoRepository repository;

    @Transactional
    public CompraProduto salvar(CompraProduto novoItem) {
    // 1. Garantir que a Compra e o Produto sejam instanciados 
    // para satisfazer o @MapsId, usando os IDs vindos na PK
    Long codCompra = novoItem.getId().getCodcomprafk();
    Long codProduto = novoItem.getId().getCodprodutofk();

    // Criamos proxies (referências) para que o JPA consiga mapear o ID
    Compra compraProxy = new Compra();
    compraProxy.setCodcompra(codCompra);
    novoItem.setCompra(compraProxy);

    Produto produtoProxy = new Produto();
    produtoProxy.setCodproduto(codProduto);
    novoItem.setProduto(produtoProxy);

    // 2. Lógica de Update ou Insert (como conversamos antes)
    Optional<CompraProduto> itemExistente = repository.findById(novoItem.getId());

    if (itemExistente.isPresent()) {
        CompraProduto itemParaAtualizar = itemExistente.get();
        itemParaAtualizar.setQuantidade(itemParaAtualizar.getQuantidade() + novoItem.getQuantidade());
        itemParaAtualizar.setValorcp(novoItem.getValorcp());
        return repository.save(itemParaAtualizar);
    } else {
        return repository.save(novoItem);
    }
}

    public List<CompraProduto> listarTodos() {
        return repository.findAll();
    }
}