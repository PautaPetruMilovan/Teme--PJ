package org.example;

public class Lab7Ex2Chitara extends Lab7Ex2InstrumentMuzical {
    public enum TipChitara {
        ELECTRICA, ACUSTICA, CLASICA
    }

    private TipChitara tipChitara;
    private int nrCorzi;

    // Constructor
    public Lab7Ex2Chitara(String producator, double pret, TipChitara tipChitara, int nrCorzi) {
        super(producator, pret);
        this.tipChitara = tipChitara;
        this.nrCorzi = nrCorzi;
    }

    // Constructor fără parametri (necesar pentru Jackson)
    public Lab7Ex2Chitara() {}

    // Gettere și settere
    public TipChitara getTipChitara() {
        return tipChitara;
    }

    public void setTipChitara(TipChitara tipChitara) {
        this.tipChitara = tipChitara;
    }

    public int getNrCorzi() {
        return nrCorzi;
    }

    public void setNrCorzi(int nrCorzi) {
        this.nrCorzi = nrCorzi;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tip Chitara: " + tipChitara + ", Nr. Corzi: " + nrCorzi;
    }
}
