public abstract class Guerrier {
    private final static int FORCE_INITIALE = 10;
    private final static int PV_INITIALE = 100;
    private final static int COUT_INITIALE = 1;

    private int force;
    private int pointsDeVie;
    private int cout;

    public Guerrier() {
        this.force = FORCE_INITIALE;
        this.pointsDeVie = PV_INITIALE;
        this.cout = COUT_INITIALE;
    }

    public int getForce() {
        return force;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public int getCout() {
        return cout;
    }

    public String getType(){
        return this.getClass().getSimpleName();
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    public boolean estVivant() {
        return this.pointsDeVie > 0;
    }

    public void attaquer(Guerrier guerrier){
        guerrier.subirDegats(PlateauUtilitaire.De3(getForce()));
    }

    protected void subirDegats(int degats){
        setPointsDeVie(this.pointsDeVie - degats);
        if(this.pointsDeVie < 0){
            setPointsDeVie(0);
        }
    }
}
