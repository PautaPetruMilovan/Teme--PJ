import java.util.Random;

public class Ex5 {
    public static void main(String[] args) {
        Random random = new Random();

        // Generarea unui număr între 0 și 20
        int numar = random.nextInt(21); // nextInt(21) generează un număr între 0 și 20 inclusiv

        // Afișarea numărului generat
        System.out.println("Numărul generat este: " + numar);

        // Verificarea dacă numărul aparține șirului lui Fibonacci
        if (esteFibonacci(numar)) {
            System.out.println("Numărul " + numar + " aparține șirului lui Fibonacci.");
        } else {
            System.out.println("Numărul " + numar + " nu aparține șirului lui Fibonacci.");
        }
    }

    // Metodă pentru verificarea apartenenței la șirul lui Fibonacci
    private static boolean esteFibonacci(int numar) {
        if (numar == 0 || numar == 1) {
            return true;
        }

        int a = 0, b = 1;
        while (b < numar) {
            int temp = a + b;
            a = b;
            b = temp;
        }

        return b == numar;
    }
}