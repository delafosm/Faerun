import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utilitaire {
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
        setConsoleColor(chateau.getCouleur());
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
        resetConsoleColor();
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
                setConsoleColor(Couleur.BLEU);
                afficherGuerriers(carreau.getGuerriers(Couleur.BLEU));
                resetConsoleColor();
            } else { System.out.println(); }

            System.out.println("");

            if(carreau.getGuerriers(Couleur.ROUGE).size() > 0)
            {
                setConsoleColor(Couleur.ROUGE);
                afficherGuerriers(carreau.getGuerriers(Couleur.ROUGE));
                resetConsoleColor();
            } else { System.out.println(); }
        }
        System.out.println("*---------------------*");
        System.out.println("");
    }

    public static void setConsoleColor(Couleur couleur){
        if (couleur == Couleur.BLEU){
            System.out.print(Color.BLUE);
        } else {
            System.out.print(Color.RED);
        }
    }

    public static void resetConsoleColor(){
        System.out.print(Color.RESET);
    }

    public static enum Couleur {
        BLEU,
        ROUGE
    }

    enum Color {
        //Color end string, color reset
        RESET("\033[0m"),

        // Regular Colors. Normal color, no bold, background color etc.
        BLACK("\033[0;30m"),    // BLACK
        RED("\033[0;31m"),      // RED
        GREEN("\033[0;32m"),    // GREEN
        YELLOW("\033[0;33m"),   // YELLOW
        BLUE("\033[0;34m"),     // BLUE
        MAGENTA("\033[0;35m"),  // MAGENTA
        CYAN("\033[0;36m"),     // CYAN
        WHITE("\033[0;37m"),    // WHITE

        // Bold
        BLACK_BOLD("\033[1;30m"),   // BLACK
        RED_BOLD("\033[1;31m"),     // RED
        GREEN_BOLD("\033[1;32m"),   // GREEN
        YELLOW_BOLD("\033[1;33m"),  // YELLOW
        BLUE_BOLD("\033[1;34m"),    // BLUE
        MAGENTA_BOLD("\033[1;35m"), // MAGENTA
        CYAN_BOLD("\033[1;36m"),    // CYAN
        WHITE_BOLD("\033[1;37m"),   // WHITE


        // Background
        BLACK_BACKGROUND("\033[40m"),   // BLACK
        RED_BACKGROUND("\033[41m"),     // RED
        GREEN_BACKGROUND("\033[42m"),   // GREEN
        YELLOW_BACKGROUND("\033[43m"),  // YELLOW
        BLUE_BACKGROUND("\033[44m"),    // BLUE
        MAGENTA_BACKGROUND("\033[45m"), // MAGENTA
        CYAN_BACKGROUND("\033[46m"),    // CYAN
        WHITE_BACKGROUND("\033[47m");   // WHITE

        private final String code;

        Color(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return code;
        }
    }

}