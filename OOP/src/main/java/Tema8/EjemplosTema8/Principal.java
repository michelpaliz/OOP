package Tema8.EjemplosTema8;

import Tema8.EjemplosTema8.Cajero.Cajero;
//import EjemplosTema8.CajeroGerman.Cajero;
import Tema8.EjemplosTema8.CajeroGerman.*;
//import EjemplosTema8.Ejercicio1.Cajero.Cajero;
import Tema8.EjemplosTema8.Ejercicio1.Ejercicio1;

public class Principal {
    public static void main(String[] args) {
        // *EJEMPLO
        // hemos invocado datos a persona
        Persona p1 = new Persona("28", "Pepe", "Garcia", 20, Genero.FEMENINO);
        Persona p2 = new Persona("47", "", "", 20, Genero.MASCULINO);
        Persona p3 = new Persona(); // este se rellena automaticamente solo
        Persona p4 = new Persona("88", "Pablo");

        // Personas
        System.out.println(p3.toString());
        System.out.println(p4.toString());
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        // Ejecicio1
        System.out.println("********************************************");
        System.out.println("Ejercicios de la hoja");
        Ejercicio1 ejercicio1 = new Ejercicio1();
        Principal principal = new Principal();
        principal.toString();
        // Cajero;
        System.out.println("EJERCICIO CAJERO");
        Cajero cajero1 = new Cajero();
        // CajeroGerman
        System.out.println("*****EJERCICIO CAJERO GERMAN *******");
        Cajero cajero = new Cajero();
        // Torneo Futbol
        System.out.println("*****EJERCICIO DE FUTBOL********");
        // Torneo torneo = new Torneo();

    }

}
