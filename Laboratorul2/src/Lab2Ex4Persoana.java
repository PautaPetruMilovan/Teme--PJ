import java.time.LocalDate;

public class Lab2Ex4Persoana {
    private String nume;
    private String cnp;

    // Constructor
    public Lab2Ex4Persoana(String nume, String cnp) {
        this.nume = nume;
        this.cnp = cnp;
    }

    // Gettere și settere
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    // Metodă pentru calcularea vârstei
    public int getVarsta() {
        int anNastere, lunaNastere, ziNastere;

        // Extragem data nașterii din CNP
        int secol = switch (cnp.charAt(0)) {
            case '1', '2' -> 1900; // Secolul 20
            case '5', '6' -> 2000; // Secolul 21
            default -> throw new IllegalArgumentException("CNP invalid!");
        };

        anNastere = secol + Integer.parseInt(cnp.substring(1, 3));
        lunaNastere = Integer.parseInt(cnp.substring(3, 5));
        ziNastere = Integer.parseInt(cnp.substring(5, 7));

        // Calculăm vârsta
        LocalDate dataNasterii = LocalDate.of(anNastere, lunaNastere, ziNastere);
        LocalDate dataCurenta = LocalDate.now();
        return dataCurenta.getYear() - dataNasterii.getYear() -
                (dataCurenta.getDayOfYear() < dataNasterii.getDayOfYear() ? 1 : 0);
    }

    @Override
    public String toString() {
        return nume + ", " + cnp + ", " + getVarsta() + " ani";
    }
}