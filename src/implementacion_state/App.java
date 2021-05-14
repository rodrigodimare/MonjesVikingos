package implementacion_state;

public class App {
    public static void main(String[] args) {

        Vikingo vikingo = new Vikingo();
        System.out.println(vikingo.getEstado());
        //estado normal - danioEfectuado 10 - danioRecibido 10
        vikingo.hacerDanio(10);
        vikingo.recibirDanio(10);
        System.out.println("Vikingo golpeado, su vida es de: " + vikingo.getVida());
        //estado Colerico - danioEfecutado 20 (10*2) - danioRecibido 40 (20*2)
        System.out.println(vikingo.getEstado());
        vikingo.recibirDanio(20);
        vikingo.hacerDanio(10);
        System.out.println("Vikingo golpeado, su vida es de: " + vikingo.getVida());
        //Estado Berserker - danioEfectuado 30 (10*3) - danioRecibido 5 (10/2)
        System.out.println(vikingo.getEstado());
        vikingo.hacerDanio(10);
        vikingo.recibirDanio(10);
        System.out.println("Vikingo golpeado, su vida es de: " + vikingo.getVida());
        //Le pegan en estado Berserker, sigue en estado Berserker
        System.out.println(vikingo.getEstado());
        //Baja un cambio..
        vikingo.meditar();
        System.out.println(vikingo.getEstado());

    }
}
