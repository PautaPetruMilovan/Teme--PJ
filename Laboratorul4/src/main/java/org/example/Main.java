package org.example;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Echipament> echipamente = new ArrayList<>();

        // Citire echipamente din fișier
        try (BufferedReader reader = new BufferedReader(new FileReader("electronice.txt"))) {
            String linie;
            while ((linie = reader.readLine()) != null) {
                String[] valori = linie.split(",");
                String tip = valori[0].trim();
                String denumire = valori[1].trim();
                int nr_inv = Integer.parseInt(valori[2].trim());
                double pret = Double.parseDouble(valori[3].trim());
                String zona_mag = valori[4].trim();
                Echipament.StareEchipament stare = Echipament.StareEchipament.valueOf(valori[5].trim().toUpperCase());

                switch (tip.toLowerCase()) {
                    case "imprimanta":
                        int ppm = Integer.parseInt(valori[6].trim());
                        int dpi = Integer.parseInt(valori[7].trim());
                        int p_car = Integer.parseInt(valori[8].trim());
                        echipamente.add(new Imprimanta(denumire, nr_inv, pret, zona_mag, stare, ppm, dpi, p_car));
                        break;

                    case "copiator":
                        int p_ton = Integer.parseInt(valori[6].trim());
                        String format = valori[7].trim();
                        echipamente.add(new Copiator(denumire, nr_inv, pret, zona_mag, stare, p_ton, format));
                        break;

                    case "sistemcalcul":
                        String tip_mon = valori[6].trim();
                        double vit_proc = Double.parseDouble(valori[7].trim());
                        int c_hdd = Integer.parseInt(valori[8].trim());
                        String sistem_operare = valori[9].trim();
                        echipamente.add(new SistemCalcul(denumire, nr_inv, pret, zona_mag, stare, tip_mon, vit_proc, c_hdd, sistem_operare));
                        break;

                    default:
                        System.err.println("Tip necunoscut: " + tip);
                }
            }
        } catch (IOException e) {
            System.err.println("Eroare la citirea fișierului: " + e.getMessage());
        }

        // Serializare / Deserializare și Meniu se implementează aici (dacă este necesar)
    }
}
