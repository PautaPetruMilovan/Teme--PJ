package org.example;

package com.example.masini.model;

import org.springframework.data.annotation.Id;

public class Masina {
    @Id
    private String nrInmatriculare;
    private String marca;
    private int anFabricatie;
    private String culoare;
    private int numarKilometri;

    // Getters și setters
    public String getNrInmatriculare() {
        return nrInmatriculare;
    }

    public void setNrInmatriculare(String nrInmatriculare) {
        this.nrInmatriculare = nrInmatriculare;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public int getNumarKilometri() {
        return numarKilometri;
    }

    public void setNumarKilometri(int numarKilometri) {
        this.numarKilometri = numarKilometri;
    }
}

