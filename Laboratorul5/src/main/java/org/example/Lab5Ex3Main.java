package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Lab5Ex3Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Citire din JSON
            List<Lab5Ex3Mobilier> mobilierList = mapper.readValue(new File("mobilier.json"),
                    new TypeReference<List<Lab5Ex3Mobilier>>() {});

            // Afișarea pieselor de mobilier
            System.out.println("Mobilier și plăcile care îl compun:");
            mobilierList.forEach(mobilier -> {
                System.out.println("Mobilier: " + mobilier.getNume());
                mobilier.getPlaci().forEach(placa -> System.out.println("  " + placa));
            });

            // Exemplu de afișare a detaliilor plăcilor pentru un anumit corp
            String corpMobilier = "Dulap";
            mobilierList.stream()
                    .filter(mobilier -> mobilier.getNume().equalsIgnoreCase(corpMobilier))
                    .findFirst()
                    .ifPresent(mobilier -> {
                        System.out.println("Detalii pentru " + corpMobilier + ":");
                        mobilier.getPlaci().forEach(System.out::println);
                    });

            // Calcularea numărului de coli de PAL
            int lungimeColi = 2800;
            int latimeColi = 2070;
            mobilierList.forEach(mobilier -> {
                int totalSuprafata = mobilier.getPlaci().stream()
                        .mapToInt(placa -> placa.getLungime() * placa.getLatime() * placa.getNr_bucati())
                        .sum();
                int suprafataColi = lungimeColi * latimeColi;
                int numarColi = (int) Math.ceil((double) totalSuprafata / suprafataColi);

                System.out.println("Număr de coli necesare pentru " + mobilier.getNume() + ": " + numarColi);
            });

        } catch (IOException e) {
            System.err.println("Eroare la citirea fișierului JSON: " + e.getMessage());
        }
    }
}
