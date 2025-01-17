package org.example;

import java.util.List;

public class Lab5Ex3Mobilier {
    private String nume; // Numele piesei de mobilier (ex: dulap, birou)
    private List<Lab5Ex3Placa> placi; // Lista de plăci care o compun

    // Constructor
    public Lab5Ex3Mobilier(String nume, List<Lab5Ex3Placa> placi) {
        this.nume = nume;
        this.placi = placi;
    }

    // Gettere și settere
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public List<Lab5Ex3Placa> getPlaci() {
        return placi;
    }

    public void setPlaci(List<Lab5Ex3Placa> placi) {
        this.placi = placi;
    }

    @Override
    public String toString() {
        return "Mobilier{" +
                "nume='" + nume + '\'' +
                ", placi=" + placi +
                '}';
    }
}
