package Examen.Out;

import java.util.List;

import Examen.Models.Mueble;
import Lib.Control;
import Lib.Util;

public class Tienda {
    private Inventario i;
    Mueble m;
    int user;
    String userStr;

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
                venderMueble();
                break;
            case 2:
                subMenu();
                break;
            case 3:
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
        System.out.println("Mueble seleccionado exitosamente");
        System.out.println(i.getMuebleActual());
    }

    public void importeTotal(int idMueble) {
        double km = Util.validateDouble("Introduce los km de distancia que hay hasta su casa ");
        System.out.println("Importe total =" + i.getMuebleActual().importeEnvio(km));

        // i.getCatalogoActual().getMuebles().get(idMueble).venderMueble();
    }

    public void venderMueble() {
        System.out.println("Venta del mueble");
        if (i.getMuebleActual().venderMueble() == true) {
            System.out.println("Mueble vendido exitosamente");
            System.out.println(i.getMuebleActual().getVentas());
        } else {
            System.out.println("No hay suficiente stock para vender el mueble");
        }
    }

    // SUBMENU
    public void subMenu() {
        String[] sentence = { "Volver al menu", "Clasificar por tipo", "Clasificar por stock" };
        user = Control.menuGenerator("Submenu", sentence);
        switch (user) {
            case 0:
                menu();
                break;
            case 1:
                List<Mueble> muebles;
                String[] sentence1 = { "Mueble clasico", "Muble Auxiliar" };
                user = Control.menuGenerator(0, "Clasificar por tipo", sentence1);
                muebles = i.clasificarTipo(user);
                for (Mueble mueble : muebles) {
                    System.out.println(muebles.toString());
                }
                break;
            case 2:
                break;
        }
    }

}
