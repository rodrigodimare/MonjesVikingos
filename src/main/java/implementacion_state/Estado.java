package implementacion_state;

public abstract class Estado {

    protected int danioRecibido;
    protected int danioEfectuado;

    public Estado() {
        this.danioEfectuado = 10;
    }

    public Estado recibirDanio(int danio) {
        return this;
    }

    public Estado meditar() {
        return this;
    }

    public Estado hacerDanio() {
        return this;
    }

    public int getDanioRecibido() {
        return danioRecibido;
    }

    public int getDanioEfectuado() {
        return danioEfectuado;
    }

    public void setDanioRecibido(int danioRecibido) {
        this.danioRecibido = danioRecibido;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
