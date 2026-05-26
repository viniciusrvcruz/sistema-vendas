package com.unifunec.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unifunec.vendas.models.Rua;

public interface RuaRepository extends JpaRepository<Rua, Integer> {
    Rua findByNomerua(String nomerua);

}


