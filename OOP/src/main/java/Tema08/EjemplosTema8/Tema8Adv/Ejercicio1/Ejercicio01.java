package Tema08.EjemplosTema8.Tema8Adv.Ejercicio1;

public class Ejercicio01 {

    public Ejercicio01() {
        Coche coche1 = new Coche("IBIZA", "0001 BCD");
        Coche coche2 = new Coche();
        Coche coche3 = new Coche("CORDOBA", Color.NEGRO, true, "0234 GHF", Coche.Tipo.UTILITARIO, 2021, ModalidadSeguro.TERCEROS);


        System.out.println(coche1);
        System.out.println(coche2);
        System.out.println(coche3);

        coche1.setColor(Color.AZUL);

        System.out.println(coche1);
    }
}
