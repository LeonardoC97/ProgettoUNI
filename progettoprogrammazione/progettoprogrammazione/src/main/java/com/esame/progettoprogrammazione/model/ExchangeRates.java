package com.esame.progettoprogrammazione.model;

public class ExchangeRates {
    private boolean success;
    private String terms;
    private String privacy;
    private String timestamp;
    private String source;
    private double quotes;
    private String controllo;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public double getQuotes() {
        return quotes;
    }

    public void setQuotes(double quotes) {
        this.quotes = quotes;
    }

    public String getControllo() {
        return controllo;
    }

    public void setControllo(String controllo) {
        this.controllo = controllo;
    }

    
}
