import java.util.LinkedList;

public class TestEtape2 {
    public static void main(String[] args) {
        Chateau chateau1 = new Chateau(Utilitaire.Couleur.ROUGE);
        LinkedList<Guerrier> guerrierEntraines;
        chateau1.ajoutGuerrierNovice(new Nain());
        chateau1.ajoutGuerrierNovice(new Elfe());
        chateau1.ajoutGuerrierNovice(new ChefElfe());
        chateau1.ajoutGuerrierNovice(new Elfe());
        guerrierEntraines = chateau1.entrainer();
        Utilitaire.afficherGuerriers(guerrierEntraines);
        guerrierEntraines = chateau1.entrainer();
        Utilitaire.afficherGuerriers(guerrierEntraines);
        guerrierEntraines = chateau1.entrainer();
        Utilitaire.afficherGuerriers(guerrierEntraines);
    }
}
