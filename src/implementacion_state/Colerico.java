package implementacion_state;

public class Colerico extends Estado {

    @Override
    public Estado recibirDanio() {
        return new Berserker();
    }

    @Override
    public Estado meditar() {
        return new Calmado();
    }

    @Override
    public void hacerDanio() {
        System.out.println("Daño efectuado al enemigo: 20");
    }
}
