public class Nain extends Guerrier {
    public Nain() {
        super();
    }

    @Override
    protected void subirDegats(int degats) {
        super.subirDegats(degats/2);
    }
}
