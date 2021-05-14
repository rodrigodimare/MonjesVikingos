package implementacion_state;

public class Vikingo {

    private int vida = 100;
    private Estado estado = new Normal();

    public Estado getEstado(){
        return estado;
    }

    public void recibirDanio() {
        estado = estado.recibirDanio();
    }

    public int mostrarVida(){
        return this.vida;
    }

    public void hacerDanio(){
        estado.hacerDanio();
    }

    public void meditar() {
        estado = estado.meditar();
    }
}
