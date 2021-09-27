import java.util.LinkedList;

public class Chateau {
    private final static int RESSOURCES_INITIAL = 3;
    private final static int RESSOURCES_AJOUT_TOUR = 1;

    private int ressources;
    private Utilitaire.Couleur couleur;
    private LinkedList<Guerrier> guerrierNovices;

    public Chateau(Utilitaire.Couleur couleur) {
        this.couleur = couleur;
        this.ressources = RESSOURCES_INITIAL;
        this.guerrierNovices = new LinkedList<>();
    }

    public Utilitaire.Couleur getCouleur() {
        return couleur;
    }

    public LinkedList<Guerrier> getGuerrierNovices() {
        return guerrierNovices;
    }

    public int getRessources() {
        return ressources;
    }

    public boolean estBleu(){
        return this.couleur == Utilitaire.Couleur.BLEU;
    }

    public boolean estRouge(){
        return this.couleur == Utilitaire.Couleur.ROUGE;
    }

    public void ajoutGuerrierNovice(Guerrier guerrier){
        this.guerrierNovices.addLast(guerrier);
    }

    public void ajoutGuerrierNovices(LinkedList<Guerrier> guerriers){this.guerrierNovices.addAll(guerriers);
    }

    public LinkedList<Guerrier> entrainer(){
        LinkedList<Guerrier> gEntraines = new LinkedList<>();
        LinkedList<Guerrier> gNovices = getGuerrierNovices();
        while(!gNovices.isEmpty() && this.ressources >= gNovices.getFirst().getCout()){
            gEntraines.add(gNovices.getFirst());
            this.ressources -= gNovices.removeFirst().getCout();
        }
        incrementerRessources();
        return gEntraines;
    }

    private void incrementerRessources(){
        this.ressources += RESSOURCES_AJOUT_TOUR;
    }
}
