package implementacion_state;

public class Vikingo {

    private int vida = 100;
    private Estado estado = new Normal();

    public Estado getEstado(){
        return estado;
    }

    public void recibirDanio(int danio) {
        estado = estado.recibirDanio(danio);
        this.vida -= estado.getDanioRecibido();
    }

    public int getVida(){
        return this.vida;
    }

    public void hacerDanio(int danio){
        System.out.println("El daño del vikingo es de: " + estado.hacerDanio(danio));
    }

    public void meditar() {
        estado = estado.meditar();
    }
}
