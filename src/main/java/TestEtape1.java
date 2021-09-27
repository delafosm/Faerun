public class TestEtape1 {
    public static void main(String[] args) {
        ChefNain guerrier1 = new ChefNain();
        ChefElfe guerrier2 = new ChefElfe();
        while(guerrier1.estVivant() | guerrier2.estVivant()){
            System.out.println("-----------------------");
            System.out.println("Guerrier 1 a " + guerrier1.getPointsDeVie() + "pdv");
            System.out.println("Guerrier 2 a " + guerrier2.getPointsDeVie() + "pdv");
            guerrier1.attaquer(guerrier2);
            guerrier2.attaquer(guerrier1);
        }
    }
}
