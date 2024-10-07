import java.util.ArrayList; //Přidání třídy ArrayList a rozhraní List z balíčku java.util
import java.util.List;

public class EvidencePojistenych {
    private List<Pojistenec> pojistenci;

    // Konstruktor pro inicializaci listu pojištěných
    public EvidencePojistenych() {
        pojistenci = new ArrayList<>();
    }

    // Metoda pro přidání nového pojištěnce
    public void pridejPojisteneho(Pojistenec pojistenec) {
        pojistenci.add(pojistenec);
    }

    // Metoda pro vypsání všech pojištěnců
    public List<Pojistenec> vypisVsechnyPojistence() {
        return pojistenci;
    }

    // Metoda pro vyhledání pojištěného
    public Pojistenec najdiPojisteneho(String jmeno, String prijmeni) {
        for (Pojistenec pojistenec : pojistenci) {
            if (pojistenec.getJmeno().equals(jmeno) &&
                    pojistenec.getPrijmeni().equals(prijmeni)) {
                return pojistenec;
            }
        }
        return null;//vrátí null pokud pojištěnec nebyl nalezen
    }
}
