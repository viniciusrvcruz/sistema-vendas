package com.unifunec.vendas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifunec.vendas.models.Uf;
import com.unifunec.vendas.service.UfService;

import jakarta.transaction.Transactional;



@RestController
@RequestMapping("/ufs")
public class UfController {

private final UfService ufService;

    public UfController(UfService ufService) {
        this.ufService = ufService;
        
    }

   @GetMapping("")
   public List<Uf> getAllUfs() {
       return ufService.getAllUfs();
   }  
   
   @GetMapping("/{id}")
   public Uf getUfId(@PathVariable Integer id) {
       return ufService.getUfId(id);
   }

   @DeleteMapping("/{id}")
   public void deletaUfId(@PathVariable Integer id) {
       ufService.apagaUfId(id);
   }

   @PostMapping("")
   public Uf postUf(@RequestBody Uf uf) {       
       return ufService.salvaUf(uf);

   }

   @PutMapping("/{id}")
   @Transactional
   public Uf putUf(@RequestBody Uf uf, @PathVariable Integer id) {
       return ufService.atualizaUf(uf, id);
   }
   


}
