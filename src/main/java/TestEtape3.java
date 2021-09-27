import java.util.LinkedList;

public class TestEtape3 {
    public static void main(String[] args) {
        Plateau plateau = new Plateau(5);
        LinkedList<Guerrier> guerriers = new LinkedList<>();
        guerriers.add(new ChefElfe());
        guerriers.add(new Elfe());
        Utilitaire.Couleur bleu = Utilitaire.Couleur.BLEU;
        Utilitaire.Couleur rouge = Utilitaire.Couleur.ROUGE;
        plateau.getCarreaux().get(4).ajouterGuerriers(bleu, guerriers);
        plateau.getCarreaux().get(1).ajouterGuerriers(rouge, guerriers);
        plateau.getCarreaux().get(0).ajouterGuerriers(rouge, guerriers);
        Utilitaire.afficherPlateau(plateau);
        plateau.deplaceGuerriers();
        Utilitaire.afficherPlateau(plateau);
        plateau.deplaceGuerriers();
        Utilitaire.afficherPlateau(plateau);
    }
}
