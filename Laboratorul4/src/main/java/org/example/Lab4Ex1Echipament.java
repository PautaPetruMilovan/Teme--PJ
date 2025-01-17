package org.example;

import java.io.Serializable;

public abstract class Lab4Ex1Echipament implements Serializable {
    private String denumire;
    private int nr_inv;
    private double pret;
    private String zona_mag;
    private StareEchipament stare;

    public enum StareEchipament {
        ACHIZITIONAT, EXPUS, VANDUT
    }

    // Constructor
    public Lab4Ex1Echipament(String denumire, int nr_inv, double pret, String zona_mag, StareEchipament stare) {
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.stare = stare;
    }

    // Gettere și settere
    public String getDenumire() {
        return denumire;
    }

    public int getNr_inv() {
        return nr_inv;
    }

    public double getPret() {
        return pret;
    }

    public String getZona_mag() {
        return zona_mag;
    }

    public StareEchipament getStare() {
        return stare;
    }

    public void setStare(StareEchipament stare) {
        this.stare = stare;
    }

    @Override
    public String toString() {
        return "Echipament: " + denumire + ", Nr. Inventar: " + nr_inv +
                ", Pret: " + pret + ", Zona Magazin: " + zona_mag + ", Stare: " + stare;
    }
}
