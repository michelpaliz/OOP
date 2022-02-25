package EjerciciosTema8.Pila;

import java.util.Random;

public class EjercicioPila {

    public static void pila() {
        System.out.println("PILA");
        Random r = new Random(5);
        Pila p = new Pila(10); //creacion del objeto pila con un initialSize 10
        System.out.println(p);
        for (int i = 0; i < 5; i++) {
            p.push(r.nextInt(10)); 
            System.out.println(p);
        }
        // devolver datos de la pila
        for (int i = 0; i < 5; i++) {
            System.out.println(p.pop());

        }
    }

    public EjercicioPila() {

        pila();
    }
}
