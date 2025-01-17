package org.example;

public class Copiator extends Echipament {
    private int p_ton;
    private String format;

    public Copiator(String denumire, int nr_inv, double pret, String zona_mag,
                    StareEchipament stare, int p_ton, String format) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.p_ton = p_ton;
        this.format = format;
    }

    public int getP_ton() {
        return p_ton;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return super.toString() + ", Toner: " + p_ton + ", Format: " + format;
    }
}
