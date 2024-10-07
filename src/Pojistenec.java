public class Pojistenec {
    private String jmeno;
    private String prijmeni;
    private int vek;
    private String telefon;

    // Konstruktor pro inicializaci pojištěnce
    public Pojistenec(String jmeno, String prijmeni, int vek, String telefon) {
        if (jmeno.isEmpty() || prijmeni.isEmpty()) {
            throw new IllegalArgumentException("Jméno a příjmení nesmí být prázdné.");
        }
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefon = telefon;
    }

    // Metoda pro získání jména
    public String getJmeno() {
        return jmeno;
    }

    // Metoda pro získání příjmení
    public String getPrijmeni() {
        return prijmeni;
    }
    //Metoda pro výpis informací
    @Override
    public String toString() {
        return jmeno + "\t" + prijmeni + "\t" + vek + "\t" + telefon;
    }
}
