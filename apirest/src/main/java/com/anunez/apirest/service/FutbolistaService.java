package com.anunez.apirest.service;

import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anunez.apirest.entity.Futbolista;
import com.anunez.apirest.repository.FutbolistaRepository;

@Service
public class FutbolistaService {
    @Autowired
    FutbolistaRepository futbolistaRepository;

    public List<Futbolista> ListarFutbolistas(){
        return futbolistaRepository.findAll();
    }
    public Futbolista ObtenerFutbolistaPorID(Long id) {
        return futbolistaRepository.findById(id).orElse(null);
    }
    
}
