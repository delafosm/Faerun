import java.util.LinkedList;

public class TestEtape3 {
    public static void main(String[] args) {
        Plateau plateau = new Plateau(5);
        LinkedList<Guerrier> guerriers = new LinkedList<>();
        guerriers.add(new ChefElfe());
        guerriers.add(new Elfe());
        PlateauUtilitaire.Couleur bleu = PlateauUtilitaire.Couleur.BLEU;
        PlateauUtilitaire.Couleur rouge = PlateauUtilitaire.Couleur.ROUGE;
        plateau.getCarreaux().get(4).ajouterGuerriers(bleu, guerriers);
        plateau.getCarreaux().get(1).ajouterGuerriers(rouge, guerriers);
        plateau.getCarreaux().get(0).ajouterGuerriers(rouge, guerriers);
        PlateauUtilitaire.afficherPlateau(plateau);
        plateau.deplaceGuerriers();
        PlateauUtilitaire.afficherPlateau(plateau);
        plateau.deplaceGuerriers();
        PlateauUtilitaire.afficherPlateau(plateau);
    }
}
