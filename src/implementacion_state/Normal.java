package implementacion_state;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Normal extends Estado{

    @Override
    public Estado recibirDanio() {
        return new Colerico();
    }

    @Override
    public Estado meditar() {
        return new Calmado();
    }

    @Override
    public void hacerDanio() {
        System.out.println("Daño efectuado al enemigo: 10");
    }
}
