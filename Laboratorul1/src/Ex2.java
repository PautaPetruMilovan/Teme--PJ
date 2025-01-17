import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ex2 {
    public static void main(String[] args) {
        List<Integer> numere = new ArrayList<>();

        // Citirea numerelor din fișierul in.txt
        try (BufferedReader reader = new BufferedReader(new FileReader("in.txt"))) {
            String linie;
            while ((linie = reader.readLine()) != null) {
                numere.add(Integer.parseInt(linie));
            }
        } catch (IOException e) {
            System.err.println("Eroare la citirea fișierului: " + e.getMessage());
            return;
        }

        // Calcularea valorilor necesare
        int suma = 0, minim = Integer.MAX_VALUE, maxim = Integer.MIN_VALUE;
        for (int numar : numere) {
            suma += numar;
            if (numar < minim) minim = numar;
            if (numar > maxim) maxim = numar;
        }
        double media = (double) suma / numere.size();

        // Afișarea rezultatelor pe ecran
        System.out.println("Suma: " + suma);
        System.out.println("Media: " + media);
        System.out.println("Minim: " + minim);
        System.out.println("Maxim: " + maxim);

        // Scrierea rezultatelor în fișierul out.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("out.txt"))) {
            writer.write("Suma: " + suma + "\n");
            writer.write("Media: " + media + "\n");
            writer.write("Minim: " + minim + "\n");
            writer.write("Maxim: " + maxim + "\n");
        } catch (IOException e) {
            System.err.println("Eroare la scrierea fișierului: " + e.getMessage());
        }
    }
}