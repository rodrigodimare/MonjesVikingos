package implementacion_state;

public class Berserker extends Estado {

    @Override
    public Estado recibirDanio(int danio) {
        danioRecibido = danio / 2;
        return this;
    }

    @Override
    public Estado meditar() {
        return new Normal();
    }

    @Override
    public int getDanioEfectuado() {
        return danioEfectuado * 3;
    }

}
