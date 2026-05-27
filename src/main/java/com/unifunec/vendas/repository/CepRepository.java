package com.unifunec.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unifunec.vendas.models.Cep;

public interface CepRepository extends JpaRepository<Cep, Integer>{

    boolean existsByNumerocep(String numerocep);

    boolean existsByNumerocepAndCodcepNot(String numerocep, Integer codcep);

}
