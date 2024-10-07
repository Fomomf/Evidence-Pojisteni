//Přidání třídy Scanner z balíčku java.util pro vstup od uživatele
import java.util.Scanner;

public class EvidencePojisteni {
    // inicializace evidence pojištěných
    private static EvidencePojistenych evidencePojistenych = new EvidencePojistenych();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean konecProgramu = false;
        while (!konecProgramu) { //Program běží dokud uživatel nevybere případ 4, tedy ukončení programu
            hlavniMenu();
            int vyber = Integer.parseInt(scanner.nextLine());

            switch (vyber) {
                case 1:
                    pridejPojistence();
                    break;
                case 2:
                    vypisVsechnyPojistence();
                    break;
                case 3:
                    vyhledejPojisteneho();
                    break;
                case 4:
                    System.out.println("Konec programu.");
                    return;
                default:
                    System.out.println("Neplatná volba, zkuste to znovu.");
            }
        }
    }

    // Metoda pro zobrazení hlavního menu
    private static void hlavniMenu() {
        System.out.println("Evidence pojištěných");
        System.out.println("----------------------");
        System.out.println("Vyberte si akci:");
        System.out.println("1 - Přidat nového pojištěného");
        System.out.println("2 - Vypsat všechny pojištěné");
        System.out.println("3 - Vyhledat pojištěného");
        System.out.println("4 - Konec");
    }

    // Metoda pro přidání nového pojištěnce
    private static void pridejPojistence() {
        System.out.println("Zadejte jméno pojištěného:");
        String jmeno = scanner.nextLine();
        System.out.println("Zadejte příjmení:");
        String prijmeni = scanner.nextLine();
        System.out.println("Zadejte telefonní číslo:");
        String telefon = scanner.nextLine();
        int vek = 0;
        boolean validInput = false; // Flag pro kontrolu validního vstupu

        while (!validInput) {
            System.out.println("Zadejte věk:");
            try {
                vek = Integer.parseInt(scanner.nextLine());
                validInput = true; // Nastaví flag na true pokud uživatel zadal správný datový typ
            } catch (NumberFormatException e) {
                System.out.println("Chyba: Zadaný věk není platné celé číslo. Zkuste to znovu.");
            }
        }

        try {
            Pojistenec pojistenec = new Pojistenec(jmeno, prijmeni, vek, telefon);
            evidencePojistenych.pridejPojisteneho(pojistenec);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Data byla uložena. Pokračujte libovolnou klávesou...");
        scanner.nextLine();
    }

    // Metoda pro zobrazení všech pojištěných
    private static void vypisVsechnyPojistence() {
        System.out.println();
        for (Pojistenec pojistenec : evidencePojistenych.vypisVsechnyPojistence()) {
            System.out.println(pojistenec);
        }
        System.out.println("\nPokračujte libovolnou klávesou...");
        scanner.nextLine();
    }

    // Metoda pro vyhledání pojištěnce
    private static void vyhledejPojisteneho() {
        System.out.println("Zadejte jméno pojisteného:");
        String jmeno = scanner.nextLine();
        System.out.println("Zadejte příjmení:");
        String prijmeni = scanner.nextLine();

        Pojistenec pojistenec = evidencePojistenych.najdiPojisteneho(jmeno, prijmeni);
        if (pojistenec != null) {
            System.out.println(pojistenec);
        } else {
            System.out.println("Pojištěný nebyl nalezen.");
        }
        System.out.println("\nPokračujte libovolnou klávesou...");
        scanner.nextLine();
    }
}
