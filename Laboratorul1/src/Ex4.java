import java.util.Random;

public class Ex4 {
    public static void main(String[] args) {
        Random random = new Random();

        // Generarea a două numere naturale cu valoare maximă 30
        int numar1 = random.nextInt(30) + 1; // +1 pentru a evita 0
        int numar2 = random.nextInt(30) + 1;

        // Afișarea numerelor generate
        System.out.println("Numerele generate sunt: " + numar1 + " și " + numar2);

        // Calcularea CMMDC folosind algoritmul lui Euclid
        int cmmdc = calculeazaCMMDC(numar1, numar2);

        // Afișarea rezultatului
        System.out.println("Cel mai mare divizor comun (CMMDC) al numerelor " + numar1 + " și " + numar2 + " este: " + cmmdc);
    }

    // Metodă pentru calcularea CMMDC folosind algoritmul lui Euclid
    private static int calculeazaCMMDC(int a, int b) {
        while (b != 0) {
            int rest = a % b;
            a = b;
            b = rest;
        }
        return a;
    }
}