package implementacion_state;

public class Berserker extends Estado {

    @Override
    public Estado recibirDanio() {
        return super.recibirDanio();
    }

    @Override
    public Estado meditar() {
        return new Calmado();
    }

    @Override
    public void hacerDanio() {
        super.hacerDanio();
    }
}
