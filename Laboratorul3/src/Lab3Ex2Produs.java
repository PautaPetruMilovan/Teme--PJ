import java.time.LocalDate;

public class Lab3Ex2Produs {
    private String denumire;
    private double pret;
    private int cantitate;
    private LocalDate dataExpirarii;

    // Variabilă statică pentru încasări
    private static double incasari = 0;

    // Constructor
    public Lab3Ex2Produs(String denumire, double pret, int cantitate, LocalDate dataExpirarii) {
        this.denumire = denumire;
        this.pret = pret;
        this.cantitate = cantitate;
        this.dataExpirarii = dataExpirarii;
    }

    // Gettere și settere
    public String getDenumire() {
        return denumire;
    }

    public double getPret() {
        return pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public LocalDate getDataExpirarii() {
        return dataExpirarii;
    }

    public static double getIncasari() {
        return incasari;
    }

    // Metodă pentru vânzarea unui produs
    public boolean vinde(int cantitateDeVandut) {
        if (cantitateDeVandut > cantitate) {
            return false; // Cantitate insuficientă
        }
        cantitate -= cantitateDeVandut;
        incasari += cantitateDeVandut * pret; // Actualizăm încasările
        return true;
    }

    @Override
    public String toString() {
        return denumire + ", Preț: " + pret + ", Cantitate: " + cantitate + ", Data expirării: " + dataExpirarii;
    }
}
