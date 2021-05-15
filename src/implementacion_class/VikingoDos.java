package implementacion_class;

import static implementacion_class.VikingoDos.EstadoVikingo.BERSERKER;
import static implementacion_class.VikingoDos.EstadoVikingo.CALMADO;
import static implementacion_class.VikingoDos.EstadoVikingo.COLERICO;
import static implementacion_class.VikingoDos.EstadoVikingo.NORMAL;

public class VikingoDos {

    private int vida;
    private EstadoVikingo estado;
    private final int danioEfectuado;

    public VikingoDos() {
        this.vida = 100;
        this.estado = NORMAL;
        this.danioEfectuado = 10;
    }

    public void hacerDanio() {
        int danio = this.danioEfectuado;

        switch (estado) {
            case COLERICO:
                danio *= 2;
                break;
            case BERSERKER:
                danio *= 3;
                break;
            case CALMADO:
                this.estado = NORMAL;
                break;
        }

        System.out.println("Vikingo haciendo danio de " + danio);
    }

    public void recibirDanio(int danio) {
        switch (estado) {
            case NORMAL:
                this.estado = COLERICO;
                break;
            case CALMADO:
                danio = 0;
                break;
            case COLERICO:
                danio *= 2;
                this.estado = BERSERKER;
                break;
            case BERSERKER:
                danio /= 2;
                break;
        }

        this.vida -= danio;
        System.out.println("Vikingo recibiendo danio de " + danio);
    }

    public void meditar() {
        switch (estado) {
            case CALMADO:
                break;
            case NORMAL:
                this.estado = CALMADO;
                break;
            default:
                this.estado = NORMAL;
                break;
        }

        System.out.println("Vikingo meditando...");
    }

    public int getVida() {
        return vida;
    }

    public String getEstado() {
        return "Estado del Vikingo: " + estado;
    }

    enum EstadoVikingo {
        NORMAL, COLERICO, BERSERKER, CALMADO
    }

}
