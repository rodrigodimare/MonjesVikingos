package implementacion_state;

public class Colerico extends Estado {

    @Override
    public Estado recibirDanio(int danio) {
        Estado berserker = new Berserker();
        berserker.setDanioRecibido(danio * 2);
        return berserker;
    }

    @Override
    public Estado meditar() {
        return new Normal();
    }

    public int getDanioEfectuado() {
        return danioEfectuado * 2;
    }

}
