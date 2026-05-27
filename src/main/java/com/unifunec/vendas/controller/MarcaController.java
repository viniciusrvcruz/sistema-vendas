package com.unifunec.vendas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifunec.vendas.models.Marca;
import com.unifunec.vendas.service.MarcaService;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/marcas")
public class MarcaController {

    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
        
    }

   @GetMapping("")
   public List<Marca> getAllMarcas() {
       return marcaService.getAllMarcas();
   }  
   
   @GetMapping("/{id}")
   public Marca getMarcaId(@PathVariable Integer id) {
       return marcaService.MarcaId(id);
   }

   @DeleteMapping("/{id}")
   public void deletaMarcaId(@PathVariable Integer id) {
       marcaService.apagaMarcaId(id);
   }

   @PostMapping("")
   public Marca postMarca(@RequestBody Marca marca) {       
       return marcaService.salvaMarca(marca);

   }

   @PutMapping("/{id}")
   @Transactional
   public Marca putMarca(@RequestBody Marca marca, @PathVariable Integer id) {
       return marcaService.atualizaMarca(marca, id);
   }
   
   
}
