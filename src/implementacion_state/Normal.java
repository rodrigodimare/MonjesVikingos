package implementacion_state;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Normal extends Estado{

    private int danioRecibido;

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

    @Override
    public int hacerDanio(int danio) {
        return danio;
    }

    @Override
    public int getDanioRecibido() {
        return danioRecibido;
    }

    public void setDanioRecibido(int danioRecibido) {
        this.danioRecibido = danioRecibido;
    }

}
