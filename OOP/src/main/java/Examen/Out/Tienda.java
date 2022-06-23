package Examen.Out;

import java.util.Collections;

import Examen.Models.Catalogo;
import Examen.Models.Mueble;
import Lib.Control;
import Lib.Util;
import Testing.concepts.collection.Collection;

public class Tienda {
    Inventario i;
    int user;

    public Tienda() {
        menu();
        i = new Inventario();
    }

    public void menu() {

        String tittle = "TIenda";
        String[] sentence = { "Salir", "Vender Mueble", "Busquedas", "Estadisticas" };
        user = Control.menuGenerator(tittle, sentence);
        switch (user) {
            case 0:
                System.out.println("Adios");
                break;
            case 1:
                System.out.println("Mostramos datos primero");
                System.out.println(i);
                System.out.println("Vender Mueble");
                System.out.println("Escoge el id del catalogo ");
                user = Util.myInput.nextInt();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }

    }

    // public void venderMueble(int id) {
    // Mueble m = i.c.getMuebles();
    // if (m.checkStock(m) != false) {
    // // i.listaCatalogo.remove(m.getCodigo());
    // System.out.println("Mueble eliminado");
    // } else {
    // System.out.println("No se ha podido eliminar el mueble stock vacio");
    // }
    // }

}
