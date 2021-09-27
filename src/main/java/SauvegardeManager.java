import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SauvegardeManager {
    private GsonBuilder builder;
    private Gson gson;

    public SauvegardeManager() {
        this.builder = new GsonBuilder();
        this.gson = builder.create();
    }

    public void creerSauvegardeJSON(String nomSauvegarde, Sauvegarde save){
        String encoding = "UTF-8";
        try{
            PrintWriter writer = new PrintWriter(nomSauvegarde+".json", encoding);
            writer.println(gson.toJson(save));
            writer.close();
        }
        catch (IOException e){
            System.out.println("Erreur lors de la sauvegarde json");
            e.printStackTrace();
        }
    }

    public Sauvegarde recupererSauvegarde(String nomSauvegarde){
        try {
            File myObj = new File(nomSauvegarde+".json");
            Scanner myReader = new Scanner(myObj);
            String data = myReader.nextLine();
            myReader.close();
            return gson.fromJson(data, Sauvegarde.class);
        } catch (FileNotFoundException e) {
            System.out.println("Erreur lors de la lecture de json");
            e.printStackTrace();
        }
        return null;
    }
}
