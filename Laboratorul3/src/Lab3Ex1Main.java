import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Lab3Ex1Main {
    public static void main(String[] args) {
        List<Lab3Ex1Parabola> parabole = new ArrayList<>();

        // Citirea din fișier
        try (BufferedReader reader = new BufferedReader(new FileReader("in.txt"))) {
            String linie;
            while ((linie = reader.readLine()) != null) {
                String[] coeficienti = linie.split(" ");
                int a = Integer.parseInt(coeficienti[0]);
                int b = Integer.parseInt(coeficienti[1]);
                int c = Integer.parseInt(coeficienti[2]);
                parabole.add(new Lab3Ex1Parabola(a, b, c));
            }
        } catch (IOException e) {
            System.err.println("Eroare la citirea fișierului: " + e.getMessage());
            return;
        }

        // Afișarea informațiilor pentru fiecare parabolă
        System.out.println("Lista parabolelor:");
        for (Lab3Ex1Parabola parabola : parabole) {
            double[] varf = parabola.calculeazaVarful();
            System.out.printf("%s, Vârf: (%.2f, %.2f)%n", parabola, varf[0], varf[1]);
        }

        // Calcularea și afișarea mijlocului segmentului dintre primele două parabole
        if (parabole.size() >= 2) {
            Lab3Ex1Parabola p1 = parabole.get(0);
            Lab3Ex1Parabola p2 = parabole.get(1);
            double[] mijloc = Lab3Ex1Parabola.coordonateMijlocStatic(p1, p2);
            double lungime = Lab3Ex1Parabola.lungimeSegmentStatic(p1, p2);

            System.out.printf("Mijlocul segmentului dintre %s și %s: (%.2f, %.2f)%n",
                    p1, p2, mijloc[0], mijloc[1]);
            System.out.printf("Lungimea segmentului: %.2f%n", lungime);
        } else {
            System.out.println("Nu există suficiente parabole pentru a calcula segmente.");
        }
    }
}
