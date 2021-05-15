import implementacion_state.VikingoS;

public class App {

    public static void main(String[] args) {

        VikingoS vikingo1 = new VikingoS("Ragnar");
        VikingoS vikingo2 = new VikingoS("Rollo");

        //estado normal - danioEfectuado 10 - danioRecibido 10
        vikingo1.hacerDanio(vikingo2);
        System.out.println(vikingo2.getNombre() + " golpeado, su vida es de: " + vikingo2.getVida());
        //estado Colerico - danioEfecutado 20 (*2) - danioRecibido 40 (20*2)
        System.out.println(vikingo1.getEstado());
        System.out.println(vikingo2.getEstado());
        vikingo1.hacerDanio(vikingo2);
        System.out.println(vikingo2.getNombre() + " golpeado, su vida es de: " + vikingo2.getVida());
        //Estado Berserker - danioEfectuado 30 (10*3) - danioRecibido 5 (10/2)
        System.out.println(vikingo1.getEstado());
        System.out.println(vikingo2.getEstado());
        vikingo1.hacerDanio(vikingo2);
        System.out.println(vikingo2.getNombre() + " golpeado, su vida es de: " + vikingo2.getVida());
        //Le pegan en estado Berserker, sigue en estado Berserker
        System.out.println(vikingo1.getEstado());
        System.out.println(vikingo2.getEstado());
        //Baja un cambio..
        vikingo2.meditar();
        System.out.println(vikingo1.getEstado());
        System.out.println(vikingo2.getEstado());
        vikingo2.meditar();
        System.out.println(vikingo1.getEstado());
        System.out.println(vikingo2.getEstado());
        vikingo2.meditar();
        System.out.println(vikingo1.getEstado());
        System.out.println(vikingo2.getEstado());
        vikingo1.hacerDanio(vikingo2);
        System.out.println(vikingo2.getNombre() + " golpeado, su vida es de: " + vikingo2.getVida());
        System.out.println(vikingo1.getEstado());
        System.out.println(vikingo2.getEstado());
        vikingo2.hacerDanio(vikingo1);
        System.out.println(vikingo1.getNombre() + " golpeado, su vida es de: " + vikingo1.getVida());
        System.out.println(vikingo1.getEstado());
        System.out.println(vikingo2.getEstado());

    }
}
