package com.unifunec.vendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unifunec.vendas.models.Uf;

public interface UfRepository extends JpaRepository<Uf, Integer> {
   Uf findByNomeuf(String nomeuf);
   Uf findBySiglauf(String siglauf);

   List<Uf> findByNomeufContaining(String nomeuf);
   //select * from uf where nomeuf like '%nomeuf%';

   Uf findByNomeufAndSiglauf(String nomeuf, String siglauf);

    //Buscar os códigos menores que um valor  ordenado pelo nome
    List<Uf> findByCodufLessThanOrderByNomeuf(Integer coduf);

    //CONSULTAS JPQL
    @Query("select coduf, nomeuf, siglauf from Uf where nomeuf like %:nome%")
    List<Uf> buscarUfsPorNome(String nome);

    //Buscando por intervalos between
    //select * from uf where coduf between 1 and 10;
    List<Uf> findByCodufBetween(Integer coduf1, Integer coduf2);

}


