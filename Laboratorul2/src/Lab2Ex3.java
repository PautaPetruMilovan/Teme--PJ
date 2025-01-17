import java.util.Scanner;

public class Lab2Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Citirea șirului inițial
        System.out.print("Introduceți șirul de caractere inițial: ");
        String text = scanner.nextLine();

        // Crearea unui StringBuilder pentru a manipula șirul
        StringBuilder stringBuilder = new StringBuilder(text);

        // Inserarea unui șir într-o anumită poziție
        System.out.print("Introduceți șirul de caractere de inserat: ");
        String sirDeInserat = scanner.nextLine();

        System.out.print("Introduceți poziția unde să fie inserat: ");
        int pozitieDeInserare = scanner.nextInt();
        scanner.nextLine(); // Consumă newline-ul rămas

        if (pozitieDeInserare >= 0 && pozitieDeInserare <= stringBuilder.length()) {
            stringBuilder.insert(pozitieDeInserare, sirDeInserat);
            System.out.println("Șirul după inserare: " + stringBuilder);
        } else {
            System.out.println("Poziția de inserare este invalidă!");
        }

        // Ștergerea unei porțiuni din șir
        System.out.print("Introduceți poziția de început pentru ștergere: ");
        int start = scanner.nextInt();

        System.out.print("Introduceți numărul de caractere de șters: ");
        int numarCaractere = scanner.nextInt();

        if (start >= 0 && start < stringBuilder.length() && start + numarCaractere <= stringBuilder.length()) {
            stringBuilder.delete(start, start + numarCaractere);
            System.out.println("Șirul după ștergere: " + stringBuilder);
        } else {
            System.out.println("Intervalul pentru ștergere este invalid!");
        }
    }
}
