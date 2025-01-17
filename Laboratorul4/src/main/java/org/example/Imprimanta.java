package org.example;

public class Imprimanta extends Echipament {
    private int ppm;
    private int dpi;
    private int p_car;

    public Imprimanta(String denumire, int nr_inv, double pret, String zona_mag,
                      StareEchipament stare, int ppm, int dpi, int p_car) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.ppm = ppm;
        this.dpi = dpi;
        this.p_car = p_car;
    }

    public int getPpm() {
        return ppm;
    }

    public int getDpi() {
        return dpi;
    }

    public int getP_car() {
        return p_car;
    }

    public void setP_car(int p_car) {
        this.p_car = p_car;
    }

    @Override
    public String toString() {
        return super.toString() + ", PPM: " + ppm + ", DPI: " + dpi + ", P/C: " + p_car;
    }
}
