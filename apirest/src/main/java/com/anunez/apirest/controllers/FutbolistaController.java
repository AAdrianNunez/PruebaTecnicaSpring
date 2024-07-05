package com.anunez.apirest.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.anunez.apirest.entity.Futbolista;
import com.anunez.apirest.service.FutbolistaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(path="/futbolista")

public class FutbolistaController {
   
    @Autowired
    private FutbolistaService futbolistaService;

    @GetMapping
    public List<Futbolista> getAll(){
        return futbolistaService.ListarFutbolistas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Futbolista> getById(@PathVariable Long id) {
        Futbolista futbolista = futbolistaService.ObtenerFutbolistaPorID(id);
        if (futbolista != null) {
            return ResponseEntity.ok(futbolista);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
