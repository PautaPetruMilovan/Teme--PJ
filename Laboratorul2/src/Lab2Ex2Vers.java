class Lab2Ex2Vers {
    private String text; // Versul

    // Constructor
    public Lab2Ex2Vers(String text) {
        this.text = text;
    }

    // Metodă pentru numărarea cuvintelor
    public int numarCuvinte() {
        if (text.isEmpty()) {
            return 0;
        }
        return text.split("\\s+").length; // Split după spațiu
    }

    // Metodă pentru numărarea vocalelor
    public int numarVocale() {
        int count = 0;
        for (char c : text.toLowerCase().toCharArray()) {
            if ("aeiouăîâ".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    // Metodă pentru a transforma textul în majuscule
    public String transformaInMajuscule() {
        return text.toUpperCase();
    }

    // Metodă pentru a verifica dacă textul se termină cu o grupare de litere
    public boolean seTerminaCu(String grupare) {
        return text.endsWith(grupare);
    }

    // Getter pentru text
    public String getText() {
        return text;
    }
}
