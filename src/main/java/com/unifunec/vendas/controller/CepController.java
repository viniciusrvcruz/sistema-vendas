package com.unifunec.vendas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifunec.vendas.models.Cep;
import com.unifunec.vendas.service.CepService;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/ceps")
public class CepController {

    private final CepService cepService;

    public CepController(CepService cepService) {
        this.cepService = cepService;
        
    }

   @GetMapping("")
   public List<Cep> getAllCeps() {
       return cepService.getAllCeps();
   }  
   
   @GetMapping("/{id}")
   public Cep getCepId(@PathVariable Integer id) {
       return cepService.CepId(id);
   }

   @DeleteMapping("/{id}")
   public void deletaCepId(@PathVariable Integer id) {
       cepService.apagaCepId(id);
   }

   @PostMapping("")
   public Cep postCep(@RequestBody Cep cep) {       
       return cepService.salvaCep(cep);

   }

   @PutMapping("/{id}")
   @Transactional
   public Cep putCep(@RequestBody Cep cep, @PathVariable Integer id) {
       return cepService.atualizaCep(cep, id);
   }
   
   
}
