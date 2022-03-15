package com.germangascon.tema08.ejercicio01;

public class Ejercicio1 {

    public Ejercicio1() {
        Coche c1 = new Coche();
        Coche c2 = new Coche("Seat Ibiza", "Azul", true, "0123 KVD", Coche.TipoCoche.UTILITARIO, 2019, Coche.ModalidadSeguro.TERCEROS);
        c1.imprimirCoche();
        c2.imprimirCoche();
        c1.setModelo("Peugeot 208");
        c1.setAnyo(2015);
        c1.imprimirCoche();
        c2.setColor("Verde");
        c2.imprimirCoche();
    }
}
