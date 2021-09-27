public class Elfe extends Guerrier {
    public Elfe() {
        super();
    }

    @Override
    public int getForce() {
        return super.getForce() * 2;
    }

    @Override
    public int getCout(){
        return 2;
    }
}
