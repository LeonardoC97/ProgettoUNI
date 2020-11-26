package com.esame.progettoprogrammazione.controller;

import java.util.List;

import com.esame.progettoprogrammazione.model.Valuta;
import com.esame.progettoprogrammazione.repository.ValutaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ValutaController {
    @Autowired
    private ValutaRepository rep;

    
    @GetMapping("/vediValuta")
    public List<Valuta> vediValute() {
        return (List<Valuta>) rep.findAll();
    }
    
    @PostMapping("/mandaValuta")
    public String aggiungiValuta(@RequestBody Valuta v) {
        rep.save(v);
        return "valuta aggiunta";
    }
}

