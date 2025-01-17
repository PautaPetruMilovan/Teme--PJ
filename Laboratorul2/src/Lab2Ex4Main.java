import java.util.ArrayList;
import java.util.Scanner;

public class Lab2Ex4Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Lab2Ex4Persoana> persoane = new ArrayList<>();

        System.out.print("Introduceți numărul de persoane: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consumăm newline-ul rămas

        for (int i = 0; i < n; i++) {
            System.out.println("Introduceți datele pentru persoana " + (i + 1) + ":");

            String nume;
            String cnp;

            // Citim numele
            System.out.print("Nume: ");
            nume = scanner.nextLine();

            // Validarea CNP-ului
            while (true) {
                System.out.print("CNP: ");
                cnp = scanner.nextLine();

                if (validareCNP(cnp)) {
                    break;
                } else {
                    System.out.println("CNP invalid! Reintroduceți.");
                }
            }

            // Adăugăm persoana în listă
            persoane.add(new Lab2Ex4Persoana(nume, cnp));
        }

        // Afișăm persoanele
        System.out.println("\nLista persoanelor:");
        for (Lab2Ex4Persoana persoana : persoane) {
            System.out.println(persoana);
        }
    }

    // Metodă pentru validarea CNP-ului
    public static boolean validareCNP(String cnp) {
        if (cnp.length() != 13 || !cnp.matches("\\d+")) {
            return false; // Lungime diferită de 13 sau conține caractere non-cifre
        }

        char primaCifra = cnp.charAt(0);
        if ("1256".indexOf(primaCifra) == -1) {
            return false; // Prima cifră nu este 1, 2, 5 sau 6
        }

        // Verificare cifră de control (opțională)
        int[] coeficienti = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
        int suma = 0;
        for (int i = 0; i < 12; i++) {
            suma += (cnp.charAt(i) - '0') * coeficienti[i];
        }
        int cifraControl = suma % 11;
        if (cifraControl == 10) {
            cifraControl = 1;
        }
        return cifraControl == (cnp.charAt(12) - '0');
    }
}
