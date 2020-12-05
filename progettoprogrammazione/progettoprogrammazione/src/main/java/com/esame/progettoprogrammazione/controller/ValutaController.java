package com.esame.progettoprogrammazione.controller;

import com.esame.progettoprogrammazione.controller.CurrencyLayer;
import com.esame.progettoprogrammazione.model.Valuta;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ValutaController {
    
    Valuta valuta = new Valuta();

    @GetMapping("/a")
    public static void prova(){
        CurrencyLayer.sendLiveRequest();   
    }

    @GetMapping("/currencyLayer/{id}")
    public Valuta prendiOggetti(@PathVariable Long id){
        return valuta;
    }

    @PostMapping("/currencyLayer")
    public Valuta aggiungiValori(@RequestBody Valuta v) {
        return v;
    }
    
    

    
}

