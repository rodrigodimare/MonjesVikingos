package implementacion_state;

public class Berserker extends Estado {

    private int danioRecibido;
    private int danioEfectuado;

    @Override
    public Estado recibirDanio(int danio) {
        Estado berserker = new Berserker();
        berserker.setDanioRecibido(danio/2);
        return berserker;
    }

    @Override
    public Estado meditar() {
        return new Calmado();
    }

    @Override
    public int hacerDanio(int danio) {
        return danio*3;
    }

    @Override
    public int getDanioRecibido() {
        return danioRecibido;
    }

    public void setDanioRecibido(int danioRecibido) {
        this.danioRecibido = danioRecibido;
    }

}
