package implementacion_state;

public class App {
    public static void main(String[] args) {

        Vikingo vikingo = new Vikingo();
        System.out.println(vikingo.getEstado());
        vikingo.recibirDanio();
        System.out.println(vikingo.getEstado());
        vikingo.recibirDanio();
        System.out.println(vikingo.getEstado());
        vikingo.meditar();
        System.out.println(vikingo.getEstado());

    }
}
