package com.unifunec.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unifunec.vendas.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
