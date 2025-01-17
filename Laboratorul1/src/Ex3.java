import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Citirea numărului n de la tastatură
        System.out.print("Introduceți un număr natural: ");
        int n = scanner.nextInt();

        // Afișarea divizorilor
        System.out.println("Divizorii numărului " + n + " sunt:");
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        // Verificarea dacă numărul este prim
        if (estePrim(n)) {
            System.out.println("Numărul " + n + " este un număr prim.");
        } else {
            System.out.println("Numărul " + n + " nu este un număr prim.");
        }
    }

    // Metodă pentru a verifica dacă un număr este prim
    private static boolean estePrim(int numar) {
        if (numar < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numar); i++) {
            if (numar % i == 0) {
                return false;
            }
        }
        return true;
    }
}