package implementacion_class;

import implementacion_state.Vikingo;

import java.util.Objects;

import static implementacion_class.VikingoC.EstadoVikingo.BERSERKER;
import static implementacion_class.VikingoC.EstadoVikingo.CALMADO;
import static implementacion_class.VikingoC.EstadoVikingo.COLERICO;
import static implementacion_class.VikingoC.EstadoVikingo.MUERTO;
import static implementacion_class.VikingoC.EstadoVikingo.NORMAL;

public class VikingoC extends Vikingo {

    private EstadoVikingo estado;
    private final int danioEfectuado;

    public VikingoC(String nombre) {
        super(nombre);
        this.estado = NORMAL;
        this.danioEfectuado = 10;
    }

    public int hacerDanio(VikingoC otro) {
        int danio = 0;
        if (!Objects.equals(this.estado, MUERTO)) {
            danio = this.danioEfectuado;
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

            otro.recibirDanio(danio);
        }

        System.out.println(this.nombre + " haciendo danio de " + danio);
        return danio;
    }

    private boolean recibirDanio(int danio) {
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
            case MUERTO:
                System.out.println(this.nombre + " muerto, recibiendo danio de " + danio);
                return false;
        }

        this.vida -= danio;

        if (this.vida <= 0) {
            this.estado = MUERTO;
            this.vida = 0;
        }

        System.out.println(this.nombre + " recibiendo danio de " + danio);
        return true;
    }

    public void meditar() {
        switch (estado) {
            case CALMADO:
                break;
            case NORMAL:
                this.estado = CALMADO;
                break;
            case MUERTO:
                return;
            default:
                this.estado = NORMAL;
                break;
        }

        System.out.println(this.nombre + " meditando...");
    }

    public String getEstado() {
        return "Estado de " + this.nombre + ": " + estado;
    }

    enum EstadoVikingo {
        NORMAL, COLERICO, BERSERKER, CALMADO, MUERTO
    }

}
