package com.unifunec.vendas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifunec.vendas.models.Sexo;
import com.unifunec.vendas.service.SexoService;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/sexos")
public class SexoController {

    private final SexoService sexoService;

    public SexoController(SexoService sexoService) {
        this.sexoService = sexoService;
        
    }

   @GetMapping("")
   public List<Sexo> getAllSexos() {
       return sexoService.getAllSexos();
   }  
   
   @GetMapping("/{id}")
   public Sexo getSexoId(@PathVariable Integer id) {
       return sexoService.SexoId(id);
   }

   @DeleteMapping("/{id}")
   public void deletaSexoId(@PathVariable Integer id) {
       sexoService.apagaSexoId(id);
   }

   @PostMapping("")
   public Sexo postSexo(@RequestBody Sexo sexo) {       
       return sexoService.salvaSexo(sexo);

   }

   @PutMapping("/{id}")
   @Transactional
   public Sexo putSexo(@RequestBody Sexo sexo, @PathVariable Integer id) {
       return sexoService.atualizaSexo(sexo, id);
   }
   
   
}
