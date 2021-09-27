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
        PlateauUtilitaire.Couleur bleu = PlateauUtilitaire.Couleur.BLEU;
        PlateauUtilitaire.Couleur rouge = PlateauUtilitaire.Couleur.ROUGE;

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

    public void ajouteGuerriers(PlateauUtilitaire.Couleur couleur, LinkedList<Guerrier> guerriers){
        if(couleur == PlateauUtilitaire.Couleur.BLEU){
            getCarreaux().get(getCarreaux().size()-1).ajouterGuerriers(PlateauUtilitaire.Couleur.BLEU, guerriers);
        }
        else {
            getCarreaux().get(0).ajouterGuerriers(PlateauUtilitaire.Couleur.ROUGE, guerriers);
        }
    }

    public void lanceCombat(){
        for (Carreau carreau : carreaux) {
            if(carreau.estChampDeBataille()){
                carreau.lanceCombat();
            }
        }
    }

    public PlateauUtilitaire.Couleur equipeAGagne(){
        if(getCarreaux().get(0).getGuerriers(PlateauUtilitaire.Couleur.BLEU).size() != 0){
            return PlateauUtilitaire.Couleur.BLEU;
        } else if (getCarreaux().get(getCarreaux().size()-1).getGuerriers(PlateauUtilitaire.Couleur.ROUGE).size() != 0){
            return PlateauUtilitaire.Couleur.ROUGE;
        } else {
            return null;
        }
    }
}
