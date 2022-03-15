package Tema8.EjemplosTema8.Ejercicio1;

public class Ejercicio1 {
    public Ejercicio1() {
        System.out.println("Ejercicio1");
        Coche coche1 = new Coche("IBIZA", "5555");
        Coche coche2 = new Coche();
        Coche coche3 = new Coche("CORDOBA", Color.BLANCO, true, "564654", Coche.Tipo.DEPODRTIVO, 2016, modalidadSeguro.TERCERO);

        //*************
        System.out.println(coche1);
        System.out.println(coche2);
        System.out.println(coche3);
        coche1.getColor(); /// aqui no tengo la opcion de cambiar solo puede cambiar la clase coche que es la especialista

//      coche1.color = Color.Azul; //no tiene opcion a no poner ninguna regla

    }
}
