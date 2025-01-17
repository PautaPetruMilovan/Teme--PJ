package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Year;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Lab6Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        try {
            // Citirea angajaților din JSON
            List<Angajat> angajati = mapper.readValue(new File("src/main/resources/angajati.json"),
                    new TypeReference<List<Angajat>>() {});

            // Cerința 1: Afișarea listei de angajați folosind referințe la metode
            System.out.println("Lista de angajați:");
            angajati.forEach(System.out::println);

            // Cerința 2: Angajați cu salariul peste 2500 RON
            System.out.println("\nAngajați cu salariul peste 2500 RON:");
            angajati.stream()
                    .filter(a -> a.getSalariul() > 2500)
                    .forEach(System.out::println);

            // Cerința 3: Angajați din luna aprilie anul trecut, cu funcții de conducere
            int anulCurent = Year.now().getValue();
            System.out.println("\nAngajați din luna aprilie anul trecut, cu funcții de conducere:");
            List<Angajat> angajatiAprilie = angajati.stream()
                    .filter(a -> a.getDataAngajarii().getYear() == anulCurent - 1)
                    .filter(a -> a.getDataAngajarii().getMonthValue() == 4)
                    .filter(a -> a.getPostul().toLowerCase().contains("sef") || a.getPostul().toLowerCase().contains("director"))
                    .collect(Collectors.toList());
            angajatiAprilie.forEach(System.out::println);

            // Cerința 4: Angajați fără funcții de conducere, ordonați descrescător după salariu
            System.out.println("\nAngajați fără funcții de conducere (ordonați descrescător după salariu):");
            angajati.stream()
                    .filter(a -> !(a.getPostul().toLowerCase().contains("sef") || a.getPostul().toLowerCase().contains("director")))
                    .sorted(Comparator.comparing(Angajat::getSalariul).reversed())
                    .forEach(System.out::println);

            // Cerința 5: Lista numelor scrise cu majuscule
            System.out.println("\nNumele angajaților scrise cu majuscule:");
            List<String> numeAngajati = angajati.stream()
                    .map(a -> a.getNume().toUpperCase())
                    .collect(Collectors.toList());
            numeAngajati.forEach(System.out::println);

            // Cerința 6: Afișarea salariilor mai mici de 3000 RON
            System.out.println("\nSalarii mai mici de 3000 RON:");
            angajati.stream()
                    .filter(a -> a.getSalariul() < 3000)
                    .map(Angajat::getSalariul)
                    .forEach(System.out::println);

            // Cerința 7: Datele primului angajat
            System.out.println("\nPrimul angajat al firmei:");
            Optional<Angajat> primulAngajat = angajati.stream()
                    .min(Comparator.comparing(Angajat::getDataAngajarii));
            primulAngajat.ifPresentOrElse(
                    System.out::println,
                    () -> System.out.println("Nu există angajați.")
            );

            // Cerința 8: Statistici despre salarii
            System.out.println("\nStatistici despre salarii:");
            var statistici = angajati.stream()
                    .collect(Collectors.summarizingDouble(Angajat::getSalariul));
            System.out.println("Salariu mediu: " + statistici.getAverage());
            System.out.println("Salariu minim: " + statistici.getMin());
            System.out.println("Salariu maxim: " + statistici.getMax());

            // Cerința 9: Există vreun angajat cu numele Ion?
            System.out.println("\nExistă un angajat cu numele Ion?");
            boolean existaIon = angajati.stream()
                    .anyMatch(a -> a.getNume().toLowerCase().contains("ion"));
            if (existaIon) {
                System.out.println("Firma are cel puțin un Ion angajat.");
            } else {
                System.out.println("Firma nu are nici un Ion angajat.");
            }

            // Cerința 10: Numărul persoanelor angajate anul trecut
            System.out.println("\nNumărul de persoane angajate anul trecut:");
            long angajatiAnulTrecut = angajati.stream()
                    .filter(a -> a.getDataAngajarii().getYear() == anulCurent - 1)
                    .count();
            System.out.println(angajatiAnulTrecut);

        } catch (IOException e) {
            System.err.println("Eroare la citirea fișierului JSON: " + e.getMessage());
        }
    }
}
