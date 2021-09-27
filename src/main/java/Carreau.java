import java.util.LinkedList;
import java.util.List;

public class Carreau {
    private LinkedList<Guerrier> guerriersBleus;
    private LinkedList<Guerrier> guerriersRouges;

    public Carreau() {
        this.guerriersBleus = new LinkedList<>();
        this.guerriersRouges = new LinkedList<>();
    }

    public LinkedList<Guerrier> getGuerriers(Utilitaire.Couleur couleur) {
        if(couleur == Utilitaire.Couleur.ROUGE){
            return guerriersRouges;
        } else {
            return guerriersBleus;
        }
    }

    public LinkedList<Guerrier> retirerGuerriers(Utilitaire.Couleur couleur){
        LinkedList<Guerrier> guerriers;
        if(couleur == Utilitaire.Couleur.ROUGE){
            guerriers = (LinkedList<Guerrier>) guerriersRouges.clone();
            guerriersRouges.clear();
        } else {
            guerriers = (LinkedList<Guerrier>) guerriersBleus.clone();
            guerriersBleus.clear();
        }
        return guerriers;
    }

    public void ajouterGuerriers(Utilitaire.Couleur couleur, LinkedList<Guerrier> guerriers){
        if(couleur == Utilitaire.Couleur.ROUGE){
            guerriersRouges.addAll(guerriers);
        } else {
            guerriersBleus.addAll(guerriers);
        }
    }

    private void supprimerGuerrier(List<Guerrier> guerriers){

    }

    public void lanceCombat(){
        //les rouges tapent
        for (Guerrier g : guerriersRouges) {
            g.attaquer(guerriersBleus.getFirst());
            if(!guerriersBleus.getFirst().estVivant()){
                guerriersBleus.removeFirst();
            }
        }
        //les bleus tapent
        for (Guerrier g : guerriersBleus) {
            g.attaquer(guerriersRouges.getFirst());
            if(!guerriersRouges.getFirst().estVivant()){
                guerriersRouges.removeFirst();
            }
        }
    }


    public boolean estChampDeBataille() {
        return !(this.guerriersBleus.isEmpty()) && !(this.guerriersRouges.isEmpty());
    }
}
