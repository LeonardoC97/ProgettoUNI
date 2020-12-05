package com.esame.progettoprogrammazione.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Valuta {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int valoreIniziale;
    private String valutaIniziale;
    private String valutaFinale;

    public int getValoreIniziale() {
        return valoreIniziale;
    }

    public void setValoreIniziale(int valoreIniziale) {
        this.valoreIniziale = valoreIniziale;
    }


    public String getValutaIniziale() {
        return valutaIniziale;
    }

    public void setValutaIniziale(String valutaIniziale) {
        this.valutaIniziale = valutaIniziale;
    }

    public String getValutaFinale() {
        return valutaFinale;
    }

    public void setValutaFinale(String valutaFinale) {
        this.valutaFinale = valutaFinale;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
