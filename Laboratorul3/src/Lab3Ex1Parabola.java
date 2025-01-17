import java.util.Objects;

public class Lab3Ex1Parabola {
    private int a, b, c;

    // Constructor cu 3 parametri
    public Lab3Ex1Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Metodă pentru calcularea vârfului parabolei
    public double[] calculeazaVarful() {
        double x = -b / (2.0 * a);
        double y = (-b * b + 4 * a * c) / (4.0 * a);
        return new double[]{x, y};
    }

    // Metodă pentru calcularea coordonatelor mijlocului segmentului dintre vârfuri
    public double[] coordonateMijloc(Lab3Ex1Parabola altaParabola) {
        double[] varf1 = this.calculeazaVarful();
        double[] varf2 = altaParabola.calculeazaVarful();
        double x = (varf1[0] + varf2[0]) / 2;
        double y = (varf1[1] + varf2[1]) / 2;
        return new double[]{x, y};
    }

    // Metodă statică pentru coordonatele mijlocului segmentului dintre două parabole
    public static double[] coordonateMijlocStatic(Lab3Ex1Parabola p1, Lab3Ex1Parabola p2) {
        return p1.coordonateMijloc(p2);
    }

    // Metodă pentru lungimea segmentului dintre vârfuri
    public double lungimeSegment(Lab3Ex1Parabola altaParabola) {
        double[] varf1 = this.calculeazaVarful();
        double[] varf2 = altaParabola.calculeazaVarful();
        return Math.hypot(varf1[0] - varf2[0], varf1[1] - varf2[1]);
    }

    // Metodă statică pentru lungimea segmentului dintre două parabole
    public static double lungimeSegmentStatic(Lab3Ex1Parabola p1, Lab3Ex1Parabola p2) {
        return p1.lungimeSegment(p2);
    }

    @Override
    public String toString() {
        return "f(x) = " + a + "x^2 + " + b + "x + " + c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lab3Ex1Parabola parabola = (Lab3Ex1Parabola) o;
        return a == parabola.a && b == parabola.b && c == parabola.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }
}
