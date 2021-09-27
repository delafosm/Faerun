import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;

public class Sauvegarde {
    private Chateau chateauRouge;
    private Chateau chateauBleu;
    private Plateau plateau;

    public Sauvegarde(Chateau chateauRouge, Chateau chateauBleu, Plateau plateau) {
        this.chateauRouge = chateauRouge;
        this.chateauBleu = chateauBleu;
        this.plateau = plateau;
    }

    public void set(Chateau chateauRouge, Chateau chateauBleu, Plateau plateau) {
        this.chateauRouge = chateauRouge;
        this.chateauBleu = chateauBleu;
        this.plateau = plateau;
    }

    public Chateau getChateauRouge() {
        return chateauRouge;
    }

    public Chateau getChateauBleu() {
        return chateauBleu;
    }

    public Plateau getPlateau() {
        return plateau;
    }
}
