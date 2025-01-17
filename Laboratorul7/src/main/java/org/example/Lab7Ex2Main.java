package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.DefaultBaseTypeLimitingValidator;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Lab7Ex2Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        // Activăm suportul pentru polimorfism
        mapper.activateDefaultTyping(new DefaultBaseTypeLimitingValidator());

        Set<Lab7Ex2InstrumentMuzical> instrumente = new HashSet<>();

        // Adăugăm instrumentele în colecția Set
        instrumente.add(new Lab7Ex2Chitara("Yamaha", 1200, Lab7Ex2Chitara.TipChitara.ELECTRICA, 6));
        instrumente.add(new Lab7Ex2Chitara("Fender", 1500, Lab7Ex2Chitara.TipChitara.CLASICA, 6));
        instrumente.add(new Lab7Ex2Chitara("Gibson", 2000, Lab7Ex2Chitara.TipChitara.ACUSTICA, 12));

        instrumente.add(new Lab7Ex2SetTobe("Roland", 3000, Lab7Ex2SetTobe.TipTobe.ELECTRONICE, 5, 2));
        instrumente.add(new Lab7Ex2SetTobe("Pearl", 2500, Lab7Ex2SetTobe.TipTobe.ACUSTICE, 7, 3));
        instrumente.add(new Lab7Ex2SetTobe("Tama", 2200, Lab7Ex2SetTobe.TipTobe.ACUSTICE, 6, 4));

        try {
            // Salvăm colecția în fișierul JSON
            mapper.writeValue(new File("src/main/resources/instrumente.json"), instrumente);
            System.out.println("Colecția a fost salvată în 'instrumente.json'.");

            // Încărcăm colecția din fișierul JSON
            Set<Lab7Ex2InstrumentMuzical> instrumenteDinJson = mapper.readValue(
                    new File("src/main/resources/instrumente.json"),
                    mapper.getTypeFactory().constructCollectionType(Set.class, Lab7Ex2InstrumentMuzical.class)
            );
            System.out.println("\nColecția încărcată din JSON:");
            instrumenteDinJson.forEach(System.out::println);

            // Verificăm duplicatele
            System.out.println("\nVerificarea duplicate:");
            if (instrumenteDinJson.size() != instrumente.size()) {
                System.out.println("Există duplicate în colecție.");
            } else {
                System.out.println("Nu există duplicate.");
            }

            // Ștergem instrumentele cu preț mai mare de 3000 RON
            System.out.println("\nȘtergerea instrumentelor cu preț > 3000 RON:");
            instrumenteDinJson.removeIf(instrument -> instrument.getPret() > 3000);
            instrumenteDinJson.forEach(System.out::println);

            // Afișăm toate chitarele
            System.out.println("\nChitarele din colecție:");
            instrumenteDinJson.stream()
                    .filter(Lab7Ex2Chitara.class::isInstance)
                    .forEach(System.out::println);

            // Afișăm toate seturile de tobe
            System.out.println("\nSeturile de tobe din colecție:");
            instrumenteDinJson.stream()
                    .filter(Lab7Ex2SetTobe.class::isInstance)
                    .forEach(System.out::println);

            // Afișăm chitara cu cele mai multe corzi
            System.out.println("\nChitara cu cele mai multe corzi:");
            instrumenteDinJson.stream()
                    .filter(Lab7Ex2Chitara.class::isInstance)
                    .map(Lab7Ex2Chitara.class::cast)
                    .max(Comparator.comparingInt(Lab7Ex2Chitara::getNrCorzi))
                    .ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("Nu există chitare în colecție.")
                    );

            // Afișăm seturile de tobe acustice, ordonate după numărul de tobe
            System.out.println("\nTobele acustice ordonate după numărul de tobe:");
            instrumenteDinJson.stream()
                    .filter(Lab7Ex2SetTobe.class::isInstance)
                    .map(Lab7Ex2SetTobe.class::cast)
                    .filter(tobe -> tobe.getTipTobe() == Lab7Ex2SetTobe.TipTobe.ACUSTICE)
                    .sorted(Comparator.comparingInt(Lab7Ex2SetTobe::getNrTobe))
                    .forEach(System.out::println);

        } catch (IOException e) {
            System.err.println("Eroare la citirea sau scrierea fișierului JSON: " + e.getMessage());
        }
    }
}
