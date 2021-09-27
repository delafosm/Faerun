import java.util.LinkedList;

public class TestEtape4 {
    public static void main(String[] args) {
        Plateau plateau = new Plateau(5);
        LinkedList<Guerrier> guerriersBleus = new LinkedList<>();
        guerriersBleus.add(new ChefNain());
        guerriersBleus.add(new ChefNain());
        LinkedList<Guerrier> guerriersRouges = new LinkedList<>();
        guerriersRouges.add(new ChefElfe());
        guerriersRouges.add(new ChefElfe());
        Utilitaire.Couleur bleu = Utilitaire.Couleur.BLEU;
        Utilitaire.Couleur rouge = Utilitaire.Couleur.ROUGE;
        plateau.getCarreaux().get(4).ajouterGuerriers(bleu, guerriersBleus);
        plateau.getCarreaux().get(4).ajouterGuerriers(rouge, guerriersRouges);
        Utilitaire.afficherPlateau(plateau);
        plateau.lanceCombat();
        Utilitaire.afficherPlateau(plateau);
    }
}
