package Examen.Out;

import java.util.ArrayList;
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
        String[] sentence = { "Salir", "Vender Mueble", "Busquedas", "Estadisticas", "Registro Ventas" };
        user = Control.menuGenerator(tittle, sentence);
        switch (user) {
            case 0:
                System.out.println("Adios");
                break;
            case 1:
                venderMueble();
                break;
            case 2:
                subMenu();
                break;
            case 3:
                mostrarEstadisticas();
                break;
            case 4:
                mostrarVentas();
                break;
        }

    }

    public void mostrarCatalogos() {
        System.out.println("Mostramos datos primero");
        i.ordenarCatalagos();
    }

    public void mostrarMuebles() {
        System.out.println("Ordenar los muebles del catalogo seleccionado por los nombres");
        i.ordenarMuebles();
    }

    public void mostrarVentas() {
        System.out.println("Ordenar registros de ventas por anyo");
        i.ordenarVentas();
    }

    public void importeTotal(int idMueble) {
        double km = Util.validateDouble("Introduce los km de distancia que hay hasta su casa ");
        System.out.println("Importe total =" + i.getMuebleActual().importeEnvio(km));
        // i.getCatalogoActual().getMuebles().get(idMueble).venderMueble();
    }

    public void venderMueble() {
        System.out.println("Tenemos " + i.getCatalagos().size() + " catalogos");
        mostrarCatalogos();
        System.out.println("Vender Mueble");
        System.out.println("Escoge el id del catalogo ");
        user = Util.myInput.nextInt();
        i.setCatalogoSeleccionado(user);
        System.out.println("Catalogo seleccionado exitosamente");
        System.out.println("-------------------");
        System.out.println("Escoge el id del mueble");
        mostrarMuebles();
        user = Util.myInput.nextInt();
        i.setMuebleSeleccionado(user);
        System.out.println("Mueble seleccionado exitosamente");
        System.out.println(i.getMuebleActual());

        System.out.println("Venta del mueble");
        if (i.getMuebleActual().venderMueble(Util.validateInt("Introduce las unidades que quieres comprar", 0,
                i.getMuebleActual().getStock())) == true) {
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
                porTipo();
                break;
            case 2:
                porStock();
                break;
        }
    }

    public void porTipo() {
        List<Mueble> muebles = new ArrayList<>();
        mostrarCatalogos();
        String[] sentence1 = { "Mueble clasico", "Mueble Auxiliar" };
        user = Control.menuGenerator(0, "Clasificar por tipo", sentence1);
        muebles = i.clasificarTipo(user);
        System.out.println(muebles);
    }

    public void porStock() {
        List<Mueble> muebles = i.totalMuebles();
        muebles.sort(new Mueble.ordenarPorStock());
        for (Mueble m : muebles) {
            if (m.getStock() == 0) {
                System.out.println("\u001b[31m" + m.toString());
            } else if (m.getStock() <= 2) {
                System.out.println("\u001b[36m" + m.toString());
            } else if (m.getStock() > 2) {
                System.out.println("\u001b[32m" + m.toString());
            }

        }
    }

    public void mostrarEstadisticas() {
        System.out.println("Media de precio de los muebles" + i.mediaPrecioMuebles());
        System.out.println("Muebles mas vendido" + i.muebleMasVendido());
    }

}
