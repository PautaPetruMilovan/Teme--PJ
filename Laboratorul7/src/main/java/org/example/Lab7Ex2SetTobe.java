package org.example;

public class Lab7Ex2SetTobe extends Lab7Ex2InstrumentMuzical {
    public enum TipTobe {
        ELECTRONICE, ACUSTICE
    }

    private TipTobe tipTobe;
    private int nrTobe;
    private int nrCinele;

    // Constructor
    public Lab7Ex2SetTobe(String producator, double pret, TipTobe tipTobe, int nrTobe, int nrCinele) {
        super(producator, pret);
        this.tipTobe = tipTobe;
        this.nrTobe = nrTobe;
        this.nrCinele = nrCinele;
    }

    // Constructor fără parametri (necesar pentru Jackson)
    public Lab7Ex2SetTobe() {}

    // Gettere și settere
    public TipTobe getTipTobe() {
        return tipTobe;
    }

    public void setTipTobe(TipTobe tipTobe) {
        this.tipTobe = tipTobe;
    }

    public int getNrTobe() {
        return nrTobe;
    }

    public void setNrTobe(int nrTobe) {
        this.nrTobe = nrTobe;
    }

    public int getNrCinele() {
        return nrCinele;
    }

    public void setNrCinele(int nrCinele) {
        this.nrCinele = nrCinele;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tip Tobe: " + tipTobe + ", Nr. Tobe: " + nrTobe + ", Nr. Cinele: " + nrCinele;
    }
}
