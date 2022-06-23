package Examen.Out;

import java.util.Collections;
import java.util.List;

import Examen.Models.Catalogo;
import Examen.Models.Mueble;
import Lib.Control;
import Lib.Util;
import Testing.concepts.collection.Collection;

public class Tienda {
    Inventario i;
    int user;
    String userStr;
    Catalogo c;

    public Tienda() {
        i = new Inventario();
        menu();
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
                mostrarCatalogos();
                mostrarMuebles();
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

    public void mostrarCatalogos() {
        System.out.println("Mostramos datos primero");
        i.ordenarCatalagos();
        System.out.println("Tenemos " + i.getCatalagos().size() + " catalogos");
        System.out.println("Vender Mueble");
        System.out.println("Escoge el id del catalogo ");
        user = Util.myInput.nextInt();
        i.setCatalogoSeleccionado(user);
    }

    public void mostrarMuebles() {
        System.out.println("Ordenar los muebles del catalogo por los nombres");
        i.ordenarMuebles();
        System.out.println("Escoge el id del mueble");
        user = Util.myInput.nextInt();
        i.setMuebleSeleccionado(user);
    }

}
