package com.esame.progettoprogrammazione.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Valuta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int denaro;
    private String valutainiziale;
    private String valutafinale;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDenaro() {
        return denaro;
    }

    public String getValutainiziale() {
        return valutainiziale;
    }

    public String getValutafinale() {
        return valutafinale;
    }

    public void setDenaro(int denaro) {
        this.denaro = denaro;
    }

    public void setValutainiziale(String valutainiziale) {
        this.valutainiziale = valutainiziale;
    }

    public void setValutafinale(String valutafinale) {
        this.valutafinale = valutafinale;
    }
    
    
}
