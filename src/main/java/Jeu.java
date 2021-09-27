public class Jeu {
    public static void main(String[] args) {
        InteractionUtilisateur interact = new InteractionUtilisateur();
        Plateau plateau = new Plateau(5);
        Utilitaire.Couleur rouge = Utilitaire.Couleur.ROUGE;
        Utilitaire.Couleur bleu = Utilitaire.Couleur.BLEU;
        Chateau chateauRouge = new Chateau(rouge);
        Chateau chateauBleu = new Chateau(bleu);
        SauvegardeManager saveManager = new SauvegardeManager();
        String input;
        Boolean sauvegarder = false;

        //Charge la partie si besoin
        input = interact.chargerUnePartie();
        if(input != null){
            Sauvegarde save = saveManager.recupererSauvegarde("partie1");
            chateauRouge = save.getChateauRouge();
            chateauBleu = save.getChateauBleu();
            plateau = save.getPlateau();
            sauvegarder = true;
        }

        while(plateau.equipeAGagne() == null || sauvegarder){ //Tant qu'il n'y a pas de gagnant
            //Sauvegarde si demande
            input = interact.demandeSauvegarde();
            if(input != null){
                Sauvegarde save = new Sauvegarde(chateauRouge, chateauBleu, plateau);
                saveManager.creerSauvegardeJSON(input, save);
            }

            //Bleu ajoute les guerriers
            chateauBleu.ajoutGuerrierNovices(interact.entrerGuerrierAFormer(bleu));
            plateau.ajouteGuerriers(bleu, chateauBleu.entrainer());

            //Rouge ajoute les guerriers
            chateauRouge.ajoutGuerrierNovices(interact.entrerGuerrierAFormer(rouge));
            plateau.ajouteGuerriers(rouge, chateauRouge.entrainer());

            plateau.deplaceGuerriers();

            plateau.lanceCombat();

            Utilitaire.afficherChateau(chateauRouge);
            Utilitaire.afficherPlateau(plateau);
            Utilitaire.afficherChateau(chateauBleu);
        }

        //Sauvegarde save = saveManager.recupererSauvegarde("partie1");

        System.out.println("l'équipe "+plateau.equipeAGagne()+" gagne !");
    }
}
