package org.example;

import java.time.LocalDate;
import java.util.Objects;

public class Angajat {
    private String nume;
    private String postul;
    private LocalDate dataAngajarii;
    private float salariul;

    // Constructor fără parametri
    public Angajat() {
    }

    // Constructor cu parametri
    public Angajat(String nume, String postul, LocalDate dataAngajarii, float salariul) {
        this.nume = nume;
        this.postul = postul;
        this.dataAngajarii = dataAngajarii;
        this.salariul = salariul;
    }

    // Gettere și settere
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPostul() {
        return postul;
    }

    public void setPostul(String postul) {
        this.postul = postul;
    }

    public LocalDate getDataAngajarii() {
        return dataAngajarii;
    }

    public void setDataAngajarii(LocalDate dataAngajarii) {
        this.dataAngajarii = dataAngajarii;
    }

    public float getSalariul() {
        return salariul;
    }

    public void setSalariul(float salariul) {
        this.salariul = salariul;
    }

    @Override
    public String toString() {
        return nume + ", " + postul + ", " + dataAngajarii + ", " + salariul;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Angajat angajat = (Angajat) o;
        return Float.compare(angajat.salariul, salariul) == 0 &&
                Objects.equals(nume, angajat.nume) &&
                Objects.equals(postul, angajat.postul) &&
                Objects.equals(dataAngajarii, angajat.dataAngajarii);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, postul, dataAngajarii, salariul);
    }
}
