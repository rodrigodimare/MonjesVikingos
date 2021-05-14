package implementacion_state;

public class Normal extends Estado {

    @Override
    public Estado recibirDanio(int danio) {
        Estado colerico = new Colerico();
        colerico.setDanioRecibido(danio);
        return colerico;
    }

    @Override
    public Estado meditar() {
        return new Calmado();
    }

}
