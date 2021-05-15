package implementacion_state;

public class VikingoS extends Vikingo {

    private Estado estado;

    public VikingoS(String nombre) {
        super(nombre);
        this.estado = new Normal();
    }

    public Estado getEstado() {
        return this.estado;
    }

    private boolean recibirDanio(int danio) {
        if (this.estado instanceof Muerto) {
            return false;
        }

        this.estado = this.estado.recibirDanio(danio);
        this.vida -= estado.getDanioRecibido();

        if (this.vida <= 0) {
            this.estado = new Muerto();
            this.vida = 0;
        }

        return true;
    }

    public int hacerDanio(VikingoS otro) {
        estado = estado.hacerDanio();
        final int danioEfectuado = estado.getDanioEfectuado();

        otro.recibirDanio(danioEfectuado);
        return danioEfectuado;
    }

    public void meditar() {
        estado = estado.meditar();
    }
}
