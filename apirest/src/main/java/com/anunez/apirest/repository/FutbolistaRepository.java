package com.anunez.apirest.repository;

import com.anunez.apirest.entity.Futbolista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FutbolistaRepository extends JpaRepository<Futbolista, Long>{
    
}
