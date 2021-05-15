package implementacion_state;

public class Calmado extends Estado {

    @Override
    public Estado hacerDanio() {
        return new Normal();
    }

}
