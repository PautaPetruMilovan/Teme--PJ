import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Lab2Ex1 {
    public static void main(String[] args) {
        // Citirea datelor din fișier în tabloul de String-uri
        String[] judete;
        try (BufferedReader reader = new BufferedReader(new FileReader("judete_in.txt"))) {
            judete = reader.lines().toArray(String[]::new);
        } catch (IOException e) {
            System.err.println("Eroare la citirea fișierului: " + e.getMessage());
            return;
        }

        // Afișare lista neordonată
        System.out.println("Lista neordonată a județelor:");
        System.out.println(Arrays.toString(judete));

        // Ordonarea tabelului folosind Arrays.sort()
        Arrays.sort(judete);

        // Afișare lista ordonată
        System.out.println("\nLista ordonată a județelor:");
        System.out.println(Arrays.toString(judete));

        // Citirea județului de căutat de la tastatură
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIntroduceți județul de căutat: ");
        String judetCautat = scanner.nextLine();

        // Căutarea binară folosind Arrays.binarySearch()
        int pozitie = Arrays.binarySearch(judete, judetCautat);

        // Afișarea rezultatului
        if (pozitie >= 0) {
            System.out.println("Județul " + judetCautat + " se află pe poziția " + pozitie + " în lista ordonată.");
        } else {
            System.out.println("Județul " + judetCautat + " nu a fost găsit în lista ordonată.");
        }
    }
}