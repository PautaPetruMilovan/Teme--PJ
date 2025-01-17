import java.io.*;
import java.util.Random;


public class Lab2Ex2Main {
    public static void main(String[] args) {
        String grupareFinala = "re"; // Gruparea specificată
        Random random = new Random();

        try (
                BufferedReader reader = new BufferedReader(new FileReader("cantec_in.txt"));
                BufferedWriter writer = new BufferedWriter(new FileWriter("cantec_out.txt"))
        ) {
            String linie;
            while ((linie = reader.readLine()) != null) {
                Lab2Ex2Vers vers = new Lab2Ex2Vers(linie);
                int numarCuvinte = vers.numarCuvinte();
                int numarVocale = vers.numarVocale();

                // Generare număr aleator între 0 și 1
                double numarAleator = random.nextDouble();

                // Scrierea versului în fișierul de ieșire
                if (numarAleator < 0.1) {
                    writer.write(vers.transformaInMajuscule()); // Scrie în majuscule
                } else {
                    writer.write(vers.getText()); // Scrie normal
                }

                // Adaugă informațiile cerute
                writer.write(" | Cuvinte: " + numarCuvinte + " | Vocale: " + numarVocale);

                // Adaugă o steluță (*) dacă textul se termină cu gruparea specificată
                if (vers.seTerminaCu(grupareFinala)) {
                    writer.write(" *");
                }

                writer.newLine(); // Trece la următoarea linie
            }

            System.out.println("Fișierul cantec_out.txt a fost generat cu succes!");

        } catch (IOException e) {
            System.err.println("Eroare la citirea sau scrierea fișierelor: " + e.getMessage());
        }
    }
}
