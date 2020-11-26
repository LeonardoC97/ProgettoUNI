package com.esame.progettoprogrammazione.repository;

import com.esame.progettoprogrammazione.model.Valuta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValutaRepository extends JpaRepository<Valuta, Integer> {

    
}
