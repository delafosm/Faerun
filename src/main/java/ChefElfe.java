public class ChefElfe extends Elfe {
    public ChefElfe() {
        super();
    }

    @Override
    public int getForce() {
        return super.getForce() * 2;
    }

    @Override
    public int getCout(){
        return 4;
    }
}
