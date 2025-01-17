import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab3Ex2Main {
    public static void main(String[] args) {
        List<Lab3Ex2Produs> produse = new ArrayList<>();

        // Citirea din fișierul produse.csv
        try (BufferedReader reader = new BufferedReader(new FileReader("produse.csv"))) {
            String linie;
            while ((linie = reader.readLine()) != null) {
                String[] valori = linie.split(",");
                String denumire = valori[0].trim();
                double pret = Double.parseDouble(valori[1].trim());
                int cantitate = Integer.parseInt(valori[2].trim());
                LocalDate dataExpirarii = LocalDate.parse(valori[3].trim());

                produse.add(new Lab3Ex2Produs(denumire, pret, cantitate, dataExpirarii));
            }
        } catch (IOException e) {
            System.err.println("Eroare la citirea fișierului: " + e.getMessage());
            return;
        }

        // Meniu
        Scanner scanner = new Scanner(System.in);
        int optiune;

        do {
            System.out.println("\nMeniu:");
            System.out.println("1. Afișare produse");
            System.out.println("2. Afișare produse expirate");
            System.out.println("3. Vânzare produs");
            System.out.println("4. Afișare produs cu preț minim");
            System.out.println("5. Salvare produse cu cantitate mică");
            System.out.println("6. Ieșire");
            System.out.print("Alegeți o opțiune: ");
            optiune = scanner.nextInt();
            scanner.nextLine(); // Consumă newline-ul rămas

            switch (optiune) {
                case 1: // Afișare produse
                    System.out.println("\nLista produselor:");
                    produse.forEach(System.out::println);
                    break;

                case 2: // Afișare produse expirate
                    System.out.println("\nProduse expirate:");
                    produse.stream()
                            .filter(p -> p.getDataExpirarii().isBefore(LocalDate.now()))
                            .forEach(System.out::println);
                    break;

                case 3: // Vânzare produs
                    System.out.print("Introduceți denumirea produsului: ");
                    String denumire = scanner.nextLine();
                    System.out.print("Introduceți cantitatea de vândut: ");
                    int cantitate = scanner.nextInt();
                    scanner.nextLine(); // Consumăm newline-ul

                    Lab3Ex2Produs produsDeVandut = produse.stream()
                            .filter(p -> p.getDenumire().equalsIgnoreCase(denumire))
                            .findFirst()
                            .orElse(null);

                    if (produsDeVandut != null) {
                        if (produsDeVandut.vinde(cantitate)) {
                            System.out.println("Produs vândut cu succes!");
                            if (produsDeVandut.getCantitate() == 0) {
                                produse.remove(produsDeVandut);
                                System.out.println("Produsul a fost eliminat din listă.");
                            }
                        } else {
                            System.out.println("Cantitate insuficientă în stoc.");
                        }
                    } else {
                        System.out.println("Produsul nu a fost găsit.");
                    }
                    break;

                case 4: // Afișare produs cu preț minim
                    double pretMinim = produse.stream()
                            .mapToDouble(Lab3Ex2Produs::getPret)
                            .min()
                            .orElse(Double.MAX_VALUE);

                    System.out.println("\nProduse cu preț minim:");
                    produse.stream()
                            .filter(p -> p.getPret() == pretMinim)
                            .forEach(System.out::println);
                    break;

                case 5: // Salvare produse cu cantitate mică
                    System.out.print("Introduceți valoarea cantității: ");
                    int valoareCantitate = scanner.nextInt();
                    scanner.nextLine(); // Consumăm newline-ul

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("produse_iesire.csv"))) {
                        produse.stream()
                                .filter(p -> p.getCantitate() < valoareCantitate)
                                .forEach(p -> {
                                    try {
                                        writer.write(p.toString());
                                        writer.newLine();
                                    } catch (IOException e) {
                                        System.err.println("Eroare la scrierea fișierului: " + e.getMessage());
                                    }
                                });
                        System.out.println("Produsele au fost salvate în produse_iesire.csv.");
                    } catch (IOException e) {
                        System.err.println("Eroare la scrierea fișierului: " + e.getMessage());
                    }
                    break;

                case 6: // Ieșire
                    System.out.println("Ieșire din program.");
                    break;

                default:
                    System.out.println("Opțiune invalidă.");
            }
        } while (optiune != 6);

        // Afișare încasări totale
        System.out.printf("Încasări totale: %.2f%n", Lab3Ex2Produs.getIncasari());
    }
}
