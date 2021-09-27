import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlateauUtilitaire {
    // Attribut contenant un objet de type random
    private static final Random RANDOM = new Random();

    // Méthode qui simule le lancement d’un dé de 3 faces
    // et retourne le résultat
    public static int De3() {
        return RANDOM.nextInt(3) + 1;
    }

    // Méthode qui simule plusieurs lancés d’un dé et retourne le résultat
    public static int De3(int nombreDes) {
        int somme = 0;
        for (int i = 0; i < nombreDes; i++) {
            somme = somme + De3();
        }
        return somme;
    }

    public static void afficherChateau(Chateau chateau){
        String couleur = chateau.getCouleur().toString();
        if(couleur.length() < 5){
            couleur += " ";
        }
        System.out.println("               T~~");
        System.out.println("               |");
        System.out.println("              /\"\\");
        System.out.println("      T~~     |'| T~~");
        System.out.println("  T~~ |    T~ WWWW|");
        System.out.println("  |  /\"\\   |  |  |/\\T~~");
        System.out.println(" /\"\\ WWW  /\"\\ |' |WW|");
        System.out.println("WWWWW/\\| /   \\|'/\\|/\"\\");
        System.out.println("|   /__\\/]WWW[\\/__\\WWWW");
        System.out.println("|\"  WWWW'|I_I|'WWWW'  |");
        System.out.println("|   |' |/  -  \\|' |'  |");
        System.out.println("|   |    "+couleur +"    |   |");
        System.out.println("|   |             |   |");
        System.out.println("|   |   NOVICES   |   |");
        for (Guerrier guerrierNovice : chateau.getGuerrierNovices()) {
            System.out.print("|'  |   ");
            afficherTypeGuerrier(guerrierNovice);
            System.out.print("  |   |\n");
        }
        System.out.println("|   |             |   |");
        System.out.println("|   | RESSOURCES:"+chateau.getRessources() +"|   |");
        System.out.println("'---'--'-/___\\-'--'---'");
        System.out.println("");
    }

    public static void afficherTypeGuerrier(Guerrier g){
        String guerrier = g.getType();
        //Pour que tout les guerriers est la meme taille sur la console
        while(guerrier.length() < 8){
            guerrier += " ";
        }
        System.out.print(guerrier);
    }

    public static void afficherGuerrier(Guerrier g){
        System.out.println(g.getType() + ": " + g.getPointsDeVie()+"pv "+g.getForce()+"force");
    }

    public static void afficherGuerriers(List<Guerrier> glist){
        for (Guerrier g : glist) {
            afficherGuerrier(g);
        }
    }

    public static void afficherPlateau(Plateau p){
        for (Carreau carreau : p.getCarreaux()) {
            System.out.println("*---------------------*");
            if(carreau.getGuerriers(Couleur.BLEU).size() > 0)
            {
                System.out.println("         BLEUS:        ");
                afficherGuerriers(carreau.getGuerriers(Couleur.BLEU));
            } else { System.out.println(); }

            System.out.println();

            if(carreau.getGuerriers(Couleur.ROUGE).size() > 0)
            {
                System.out.println("        ROUGES:        ");
                afficherGuerriers(carreau.getGuerriers(Couleur.ROUGE));
            } else { System.out.println(); }
        }
        System.out.println("*---------------------*");
        System.out.println("");
    }

    public static enum Couleur {
        BLEU,
        ROUGE
    }

}