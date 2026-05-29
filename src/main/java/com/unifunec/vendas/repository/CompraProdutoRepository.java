package com.unifunec.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unifunec.vendas.models.CompraProduto;
import com.unifunec.vendas.models.CompraProdutoPK;

@Repository
public interface CompraProdutoRepository extends JpaRepository<CompraProduto, CompraProdutoPK> {

    boolean existsByCompra_Codcompra(Long codcompra);

    boolean existsByProduto_Codproduto(Long codproduto);
}
