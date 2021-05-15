package implementacion_state;

public class Vikingo {
    protected final String nombre;
    protected int vida;

    protected Vikingo(String nombre) {
        this.nombre = nombre;
        this.vida = 100;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }
}
