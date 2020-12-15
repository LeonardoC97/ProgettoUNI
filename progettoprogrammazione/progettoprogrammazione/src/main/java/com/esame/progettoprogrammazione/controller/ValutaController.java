package com.esame.progettoprogrammazione.controller;


import java.io.IOException;

import com.esame.progettoprogrammazione.model.ExchangeRates;
import com.esame.progettoprogrammazione.model.Valuta;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ValutaController {

    Valuta valuta = new Valuta();
    CurrencyLayer c = new CurrencyLayer();

    @GetMapping("/currency")
    public ExchangeRates currencyCorrente(@RequestParam String valutaFinale, int valoreIniziale) throws JSONException, ClientProtocolException, IOException {
        ExchangeRates exchange = new ExchangeRates();
        valuta.setValutaFinale(valutaFinale);
        valuta.setValoreIniziale(valoreIniziale);
        exchange = CurrencyLayer.sendLiveRequest(valuta.getValutaFinale(),valuta.getValoreIniziale());
        return exchange;
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

