import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class InteractionUtilisateur {
    private Scanner scanner;

    public InteractionUtilisateur() {
        this.scanner = new Scanner(System.in);
    }

    public LinkedList<Guerrier> entrerGuerrierAFormer(PlateauUtilitaire.Couleur couleur){
        String input;
        String[] typeGuerrierDemandes;
        LinkedList<Guerrier> guerriersAFormer = new LinkedList<>();
        System.out.println(couleur+" joue :");
        System.out.println("Entrez les lettres des guerriers à former (Séparer les par des espaces)");
        System.out.println("N (Nain), E (Elfe), CN (Chef Nain), CE (Chef Elfe) :");
        input = scanner.nextLine();
        typeGuerrierDemandes = input.trim().split("\\s+");
        for (String guerrierDemande : typeGuerrierDemandes) {
            switch (guerrierDemande){
                case "N": guerriersAFormer.add(new Nain());
                    break;
                case "E": guerriersAFormer.add(new Elfe());
                    break;
                case "CN": guerriersAFormer.add(new ChefNain());
                    break;
                case "CE": guerriersAFormer.add(new ChefElfe());
                    break;
            }
        }
        return guerriersAFormer;
    }
}
