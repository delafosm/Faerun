import java.util.LinkedList;
import java.util.Scanner;

public class InteractionUtilisateur {
    private Scanner scanner;

    public InteractionUtilisateur() {
        this.scanner = new Scanner(System.in);
    }

    public LinkedList<Guerrier> entrerGuerrierAFormer(Utilitaire.Couleur couleur){
        String input;
        String[] typeGuerrierDemandes;
        LinkedList<Guerrier> guerriersAFormer = new LinkedList<>();
        Utilitaire.setConsoleColor(couleur);
        System.out.println(couleur+" joue :");
        Utilitaire.resetConsoleColor();
        System.out.println("Entrez les lettres des guerriers à former (Séparer les par des espaces)");
        System.out.println("n (Nain), e (Elfe), cn (Chef Nain), ce (Chef Elfe) ou alors entrez s pour sauvegarder :");
        input = scanner.nextLine();
        typeGuerrierDemandes = input.trim().split("\\s+");
        for (String guerrierDemande : typeGuerrierDemandes) {
            switch (guerrierDemande){
                case "n": guerriersAFormer.add(new Nain());
                    break;
                case "e": guerriersAFormer.add(new Elfe());
                    break;
                case "cn": guerriersAFormer.add(new ChefNain());
                    break;
                case "ce": guerriersAFormer.add(new ChefElfe());
                    break;
            }
        }
        return guerriersAFormer;
    }

    public String chargerUnePartie(){
        String input;
        System.out.println("Voulez-vous charger une partie ? (o/n)");
        input = scanner.nextLine();
        if(input.equalsIgnoreCase("o")){
            System.out.println("Entrer le nom de la partie a charger :");
            input = scanner.nextLine();
            return input;
        } else {
            return null;
        }
    }

    public String demandeSauvegarde(){
        String input;
        System.out.println("Voulez-vous sauvegarder la partie ? (o/n)");
        input = scanner.nextLine();
        if(input.equalsIgnoreCase("o")){
            System.out.println("Entrer le nom de la partie a sauvegarder :");
            input = scanner.nextLine();
            return input;
        } else {
            return null;
        }
    }
}
