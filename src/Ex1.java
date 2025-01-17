import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Citește lungimea
        System.out.print("Introduceți lungimea dreptunghiului: ");
        double lungime = scanner.nextDouble();  // Breakpoint aici

        // Citește lățimea
        System.out.print("Introduceți lățimea dreptunghiului: ");
        double latime = scanner.nextDouble();

        // Calculează perimetrul
        double perimetru = 2 * (lungime + latime);

        // Calculează aria
        double aria = lungime * latime;

        // Afișează rezultatele
        System.out.println("Perimetrul dreptunghiului este: " + perimetru);
        System.out.println("Aria dreptunghiului este: " + aria);
    }
}