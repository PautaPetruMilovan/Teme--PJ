package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Lab7Ex1Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        Map<Integer, Lab7Ex1Carte> cartiMap;

        try {
            // Citire din fișierul JSON
            cartiMap = mapper.readValue(new File("src/main/resources/carti.json"),
                    new TypeReference<Map<Integer, Lab7Ex1Carte>>() {});

            // Cerința 1: Afișarea colecției
            System.out.println("Colecția de cărți:");
            cartiMap.forEach((id, carte) -> System.out.println(id + ": " + carte));

            // Cerința 2: Ștergerea unei cărți din colecție
            System.out.println("\nȘtergerea cărții cu ID 3:");
            cartiMap.remove(3);
            cartiMap.forEach((id, carte) -> System.out.println(id + ": " + carte));

            // Cerința 3: Adăugarea unei cărți în colecție
            System.out.println("\nAdăugarea unei noi cărți (ID 6):");
            cartiMap.putIfAbsent(6, new Lab7Ex1Carte("The Power of Now", "Eckhart Tolle", 1997));
            cartiMap.forEach((id, carte) -> System.out.println(id + ": " + carte));

            // Cerința 4: Salvarea în fișier JSON
            mapper.writeValue(new File("src/main/resources/carti_updated.json"), cartiMap);
            System.out.println("\nModificările au fost salvate în 'carti_updated.json'.");

            // Cerința 5: Crearea colecției Set<Carte> pentru cărțile lui Yuval Noah Harari
            System.out.println("\nCărțile lui Yuval Noah Harari:");
            Set<Lab7Ex1Carte> cartiHarari = cartiMap.values().stream()
                    .filter(carte -> "Yuval Noah Harari".equalsIgnoreCase(carte.autor()))
                    .collect(Collectors.toSet());
            cartiHarari.forEach(System.out::println);

            // Cerința 6: Afișarea ordonată după titlu a colecției Set
            System.out.println("\nCărți ordonate după titlu:");
            cartiHarari.stream()
                    .sorted(Comparator.comparing(Lab7Ex1Carte::titlu))
                    .forEach(System.out::println);

            // Cerința 7: Cea mai veche carte din colecția Set
            System.out.println("\nCea mai veche carte din colecția Set:");
            Optional<Lab7Ex1Carte> ceaMaiVecheCarte = cartiHarari.stream()
                    .min(Comparator.comparing(Lab7Ex1Carte::an_aparitie));
            ceaMaiVecheCarte.ifPresentOrElse(
                    System.out::println,
                    () -> System.out.println("Nu există cărți în colecție.")
            );

        } catch (IOException e) {
            System.err.println("Eroare la citirea sau scrierea fișierului JSON: " + e.getMessage());
        }
    }
}
