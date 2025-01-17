package org.example;

public class SistemCalcul extends Echipament {
    private String tip_mon;
    private double vit_proc;
    private int c_hdd;
    private String sistem_operare;

    public SistemCalcul(String denumire, int nr_inv, double pret, String zona_mag,
                        StareEchipament stare, String tip_mon, double vit_proc, int c_hdd, String sistem_operare) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.sistem_operare = sistem_operare;
    }

    public String getSistem_operare() {
        return sistem_operare;
    }

    public void setSistem_operare(String sistem_operare) {
        this.sistem_operare = sistem_operare;
    }

    @Override
    public String toString() {
        return super.toString() + ", Monitor: " + tip_mon + ", Procesor: " + vit_proc +
                " GHz, HDD: " + c_hdd + " GB, Sistem: " + sistem_operare;
    }
}
