package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lab5Ex2Main {

    // Metoda pentru scrierea unei liste de perechi în fișier JSON
    public static void scriere(List<Lab5Ex2PerecheNumere> lista) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("perechi.json"), lista);
            System.out.println("Datele au fost salvate în perechi.json.");
        } catch (IOException e) {
            System.err.println("Eroare la scrierea fișierului: " + e.getMessage());
        }
    }

    // Metoda pentru citirea unei liste de perechi din fișier JSON
    public static List<Lab5Ex2PerecheNumere> citire() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File("perechi.json"), new TypeReference<List<Lab5Ex2PerecheNumere>>() {});
        } catch (IOException e) {
            System.err.println("Eroare la citirea fișierului: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        // Creăm câteva perechi de test
        List<Lab5Ex2PerecheNumere> perechi = new ArrayList<>();
        perechi.add(new Lab5Ex2PerecheNumere(8, 13)); // Fibonacci
        perechi.add(new Lab5Ex2PerecheNumere(12, 18)); // CMMMC
        perechi.add(new Lab5Ex2PerecheNumere(14, 28)); // Suma cifrelor egale

        // Afișăm perechile
        System.out.println("Lista de perechi:");
        perechi.forEach(System.out::println);

        // Scriem perechile în fișier JSON
        scriere(perechi);

        // Citim perechile din fișier JSON
        List<Lab5Ex2PerecheNumere> perechiCitite = citire();
        System.out.println("Perechile citite din fișier:");
        perechiCitite.forEach(System.out::println);
    }
}
