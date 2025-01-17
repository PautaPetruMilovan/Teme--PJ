package org.example;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public abstract class Lab7Ex2InstrumentMuzical {
    private String producator;
    private double pret;

    // Constructor
    public Lab7Ex2InstrumentMuzical(String producator, double pret) {
        this.producator = producator;
        this.pret = pret;
    }

    // Constructor fără parametri (necesar pentru Jackson)
    public Lab7Ex2InstrumentMuzical() {}

    // Gettere și settere
    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Producator: " + producator + ", Pret: " + pret;
    }
}
