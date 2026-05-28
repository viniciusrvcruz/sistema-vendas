package com.unifunec.vendas.repository;

import com.unifunec.vendas.models.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {

    boolean existsByEmailfornecedor(String emailfornecedor);

    boolean existsByEmailfornecedorAndCodfornecedorNot(String emailfornecedor, Integer codfornecedor);
}
