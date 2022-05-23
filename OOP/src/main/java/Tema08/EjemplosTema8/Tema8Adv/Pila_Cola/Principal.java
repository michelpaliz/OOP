package Tema08.EjemplosTema8.Tema8Adv.Pila_Cola;



import com.github.javafaker.Faker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Principal {
    public static void main(String[] args) {
        // Ejercicio01 ejercicio01 = new Ejercicio01();
        // App app = new App();
        // Ejercicio02 ejercicio02 = new Ejercicio02();
        // Ejercicio03 ejercicio03 = new Ejercicio03();
        // Ejercicio04 ejercicio04 = new Ejercicio04();
        // Ejercicio05 ejercicio05 = new Ejercicio05();

        /* Provando la clase Pila */
        /*
         * Random r = new Random();
         * Pila p = new Pila(10);
         * System.out.println(p);
         * for(int i = 0; i < 5; i++) {
         * p.push(r.nextInt(10));
         * System.out.println(p);
         * }
         * 
         * for(int i = 0; i < 5; i++) {
         * System.out.println(p.pop());
         * }
         * System.out.println(p);
         */

        /* Provando la clase Cola */
        /*
         * Random r = new Random();
         * Cola cola = new Cola(2);
         * System.out.println(cola);
         * for(int i = 0; i < 5; i++) {
         * cola.add(i + 1);
         * System.out.println(cola);
         * }
         * 
         * // Comprobamos que funciona correctamente cuando no hay elementos
         * // ya que solo hemos metido 5 elementos e iteramos hasta 10
         * for(int i = 0; i < 10; i++) {
         * System.out.println(cola.remove());
         * }
         * System.out.println(cola);
         */

        // /* Provando la clase ColaGeneric */
        // Faker faker = new Faker(new Locale("es"));
        // // Ponemos tamaño pequeño para ver que efectivamente crece automáticamente
        // ColaGeneric<String> cola = new ColaGeneric<>(2);
        // System.out.println(cola);
        // for(int i = 0; i < 5; i++) {
        // cola.add(faker.name().firstName());
        // System.out.println(cola);
        // }

        // // Comprobamos que funciona correctamente cuando no hay elementos
        // // ya que solo hemos metido 5 elementos e iteramos hasta 10
        // for(int i = 0; i < 10; i++) {
        // System.out.println(cola.remove());
        // }
        // System.out.println(cola);

        // }

        // public static long dateDiff(String fechaInicio, String fechaFin) {
        // SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        // Date startDate = null;
        // Date endDate = null;
        // try {
        // startDate = sdf.parse(fechaInicio);
        // endDate = sdf.parse(fechaFin);
        // } catch (ParseException e) {
        // e.printStackTrace();
        // return 0;
        // }
        // Calendar start = Calendar.getInstance();
        // start.setTime(startDate);
        // Calendar end = Calendar.getInstance();
        // end.setTime(endDate);

        // long diff = end.getTimeInMillis() - start.getTimeInMillis(); //result in
        // millis
        // return diff / (24 * 60 * 60 * 1000);

    }

}
