package com.unifunec.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unifunec.vendas.models.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{
//JPQL USE A VONTADE

    Cidade findByNomecidade(String nomecidade);


}
