package Examen.Out;

import java.util.Collections;

import Examen.Models.Catalogo;
import Examen.Models.Mueble;
import Lib.Control;
import Lib.Util;
import Testing.concepts.collection.Collection;

public class Tienda {
    Inventario i = new Inventario();
    int user;

    public Tienda() {
        menu();

    }

    public void menu() {

        String tittle = "TIenda";
        String[] sentence = { "Salir", "Vender Mueble", "Busquedas", "Estadisticas" };
        user = Control.menuGenerator(tittle, sentence);
        i.gnRandom();
        i.gnRandomC();
        switch (user) {
            case 1:
                System.out.println("Vender Mueble");
                Collections.sort(i.listaMueble);
                System.out.println(i.listaMueble);
                System.out.println("Escoge el id del catalogo ");
                user = Util.myInput.nextInt();

                venderMueble(i.c.getId());

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

    public void venderMueble(int id) {

        Mueble m = c.getMuebles();
        if (m.checkStock(m) != false) {
            i.listaCatalogo.remove(m.getCodigo());
            System.out.println("Mueble eliminado");
        } else {
            System.out.println("No se ha podido eliminar el mueble stock vacio");
        }
    }



}
