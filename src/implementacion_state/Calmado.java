package implementacion_state;

public class Calmado extends Estado{

    @Override
    public Estado recibirDanio(int danio) {
        return new Normal();
    }

    @Override
    public Estado meditar() {
        return new Calmado();
    }


}
