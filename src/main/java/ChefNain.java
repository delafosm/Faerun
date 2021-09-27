public class ChefNain extends Nain {
    public ChefNain() {
        super();
    }

    @Override
    protected void subirDegats(int degats) {
        super.subirDegats(degats/2);
    }

    @Override
    public int getCout(){
        return 3;
    }
}
