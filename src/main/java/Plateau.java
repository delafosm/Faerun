import java.util.ArrayList;
import java.util.LinkedList;

public class Plateau {
    private ArrayList<Carreau> carreaux;

    public Plateau(int nbCarreaux) {
        this.carreaux = new ArrayList<>();
        for (int i = 0; i < nbCarreaux; i++) {
            carreaux.add(new Carreau());
        }
    }

    public ArrayList<Carreau> getCarreaux() {
        return carreaux;
    }

    public void deplaceGuerriers(){
        int nbCarreaux = carreaux.size();
        LinkedList<Guerrier> gBleus;
        LinkedList<Guerrier> gRouges;
        Utilitaire.Couleur bleu = Utilitaire.Couleur.BLEU;
        Utilitaire.Couleur rouge = Utilitaire.Couleur.ROUGE;

        for (int i = 0; i < nbCarreaux; i++) {
            //Deplace les bleus
            gBleus = carreaux.get(i).getGuerriers(bleu);
            if(!gBleus.isEmpty()){ //Si il y a des guerriers
                if(i != 0 & !carreaux.get(i).estChampDeBataille()){
                    gBleus = carreaux.get(i).retirerGuerriers(bleu);
                    carreaux.get(i-1).ajouterGuerriers(bleu, gBleus);
                }
            }
        }

        for (int i = 0; i < nbCarreaux; i++) {
            //Deplace les rouges
            int car = nbCarreaux-1-i; //index pour parcourir carreaux dans le sens inverse
            gRouges = carreaux.get(car).getGuerriers(rouge);
            if(!gRouges.isEmpty()){ //Si il y a des guerriers
                if(i != 0 & !carreaux.get(car).estChampDeBataille()){
                    gRouges = carreaux.get(car).retirerGuerriers(rouge);
                    carreaux.get(car+1).ajouterGuerriers(rouge, gRouges);
                }
            }
        }
    }

    public void ajouteGuerriers(Utilitaire.Couleur couleur, LinkedList<Guerrier> guerriers){
        if(couleur == Utilitaire.Couleur.BLEU){
            getCarreaux().get(getCarreaux().size()-1).ajouterGuerriers(Utilitaire.Couleur.BLEU, guerriers);
        }
        else {
            getCarreaux().get(0).ajouterGuerriers(Utilitaire.Couleur.ROUGE, guerriers);
        }
    }

    public void lanceCombat(){
        for (Carreau carreau : carreaux) {
            if(carreau.estChampDeBataille()){
                carreau.lanceCombat();
            }
        }
    }

    public Utilitaire.Couleur equipeAGagne(){
        if(getCarreaux().get(0).getGuerriers(Utilitaire.Couleur.BLEU).size() != 0){
            return Utilitaire.Couleur.BLEU;
        } else if (getCarreaux().get(getCarreaux().size()-1).getGuerriers(Utilitaire.Couleur.ROUGE).size() != 0){
            return Utilitaire.Couleur.ROUGE;
        } else {
            return null;
        }
    }
}
