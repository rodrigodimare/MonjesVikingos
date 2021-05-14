package implementacion_state;

public class Calmado extends Estado{

    @Override
    public Estado recibirDanio() {
        return new Normal();
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
