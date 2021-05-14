package implementacion_state;

public abstract class Estado {

    private int danioRecibido;

    public Estado recibirDanio(int danio){
        return this.recibirDanio(danio);
    }

    public Estado meditar(){
        return this.meditar();
    }

    public int hacerDanio(int danio){
        return this.hacerDanio(danio);
    }

    public int getDanioRecibido() {
        return danioRecibido;
    }


    public void setDanioRecibido(int danioRecibido) {
        this.danioRecibido = danioRecibido;
    }

}
