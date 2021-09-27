import java.util.ArrayList;

public class Jeu {
    public static void main(String[] args) {
        InteractionUtilisateur inter = new InteractionUtilisateur();
        Plateau plateau = new Plateau(3);
        PlateauUtilitaire.Couleur rouge = PlateauUtilitaire.Couleur.ROUGE;
        PlateauUtilitaire.Couleur bleu = PlateauUtilitaire.Couleur.BLEU;
        Chateau chateauRouge = new Chateau(rouge);
        Chateau chateauBleu = new Chateau(bleu);

        while(plateau.equipeAGagne() == null){
            chateauBleu.ajoutGuerrierNovices(inter.entrerGuerrierAFormer(bleu));
            plateau.ajouteGuerriers(bleu, chateauBleu.entrainer());

            chateauRouge.ajoutGuerrierNovices(inter.entrerGuerrierAFormer(rouge));
            plateau.ajouteGuerriers(rouge, chateauRouge.entrainer());

            plateau.deplaceGuerriers();

            plateau.lanceCombat();

            PlateauUtilitaire.afficherChateau(chateauRouge);
            PlateauUtilitaire.afficherPlateau(plateau);
            PlateauUtilitaire.afficherChateau(chateauBleu);
        }

        System.out.println("l'équipe "+plateau.equipeAGagne()+" gagne !");
    }
}
