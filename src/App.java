import implementacion_class.VikingoDos;

public class App {
    public static void main(String[] args) {

//        Vikingo vikingo = new Vikingo();
        VikingoDos vikingo = new VikingoDos();
        System.out.println(vikingo.getEstado());
        //estado normal - danioEfectuado 10 - danioRecibido 10
        vikingo.hacerDanio();
        vikingo.recibirDanio(10);
        System.out.println("Vikingo golpeado, su vida es de: " + vikingo.getVida());
        //estado Colerico - danioEfecutado 20 (*2) - danioRecibido 40 (20*2)
        System.out.println(vikingo.getEstado());
        vikingo.hacerDanio();
        vikingo.recibirDanio(20);
        System.out.println("Vikingo golpeado, su vida es de: " + vikingo.getVida());
        //Estado Berserker - danioEfectuado 30 (10*3) - danioRecibido 5 (10/2)
        System.out.println(vikingo.getEstado());
        vikingo.hacerDanio();
        vikingo.recibirDanio(10);
        System.out.println("Vikingo golpeado, su vida es de: " + vikingo.getVida());
        //Le pegan en estado Berserker, sigue en estado Berserker
        System.out.println(vikingo.getEstado());
        //Baja un cambio..
        vikingo.meditar();
        System.out.println(vikingo.getEstado());
        vikingo.meditar();
        System.out.println(vikingo.getEstado());
        vikingo.meditar();
        System.out.println(vikingo.getEstado());
        vikingo.recibirDanio(10);
        System.out.println("Vikingo golpeado, su vida es de: " + vikingo.getVida());
        System.out.println(vikingo.getEstado());
        vikingo.hacerDanio();
        System.out.println(vikingo.getEstado());
    }
}
