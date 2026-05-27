package com.unifunec.vendas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifunec.vendas.models.Bairro;
import com.unifunec.vendas.service.BairroService;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/bairros")
public class BairroController {

    private final BairroService bairroService;

    public BairroController(BairroService bairroService) {
        this.bairroService = bairroService;
        
    }

   @GetMapping("")
   public List<Bairro> getAllBairros() {
       return bairroService.getAllBairros();
   }  
   
   @GetMapping("/{id}")
   public Bairro getBairroId(@PathVariable Integer id) {
       return bairroService.BairroId(id);
   }

   @DeleteMapping("/{id}")
   public void deletaBairroId(@PathVariable Integer id) {
       bairroService.apagaBairroId(id);
   }

   @PostMapping("")
   public Bairro postBairro(@RequestBody Bairro bairro) {       
       return bairroService.salvaBairro(bairro);

   }

   @PutMapping("/{id}")
   @Transactional
   public Bairro putBairro(@RequestBody Bairro bairro, @PathVariable Integer id) {
       return bairroService.atualizaBairro(bairro, id);
   }
   
   
}
