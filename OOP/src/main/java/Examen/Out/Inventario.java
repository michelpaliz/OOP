package Examen.Out;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.github.javafaker.Faker;

import Examen.Interface.IEstadisticas;
import Examen.Models.Catalogo;
import Examen.Models.MuebleAux;
import Examen.Models.MuebleClasico;
import Examen.Models.Venta;
import Examen.numeric.Etipo;
import Examen.Models.Mueble;
import Lib.Util;

public class Inventario implements IEstadisticas {
    // Tambien se podria crear un clase aparte de configuraciones constantes para
    // este tipo
    // de funciones.
    private static Faker fk = new Faker();
    private final int MAX_MUEBLES = 20;
    private final int MAX_CATALAGOS = 3;
    private final int MAX_VENTAS = 3;
    private final boolean DEBUG = true;
    // Las variables que voy a utilizar son el core de mi aplicacion.
    protected List<Mueble> listaMueble;
    protected List<Catalogo> listaCatalogo;
    protected List<Venta> listaVentas;
    private Catalogo catalogoActual;
    private Mueble muebleActual;

    public Inventario() {
        // Creo los catalogos y los muebles a la vez podria haber creado dos distintas
        // funciones para ello.
        if (DEBUG) {
            randomCatalogos(MAX_CATALAGOS, MAX_MUEBLES);
            ventasRandom(MAX_VENTAS);
        }
    }

    public Catalogo getCatalogoActual() {
        return catalogoActual;
    }

    public Mueble getMuebleActual() {
        return muebleActual;
    }

    public List<Catalogo> getCatalagos() {
        return listaCatalogo;
    }

    public List<Mueble> getListaMueble() {
        return listaMueble;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    private void ventasRandom(int cantidad) {
        listaVentas = new ArrayList<>();
        List<Venta> todasLasVentas = new ArrayList<>();
        for (int i = 0; i < listaCatalogo.size(); i++) {
            for (int j = 0; j < listaCatalogo.get(i).getMuebles().size(); j++) {
                listaCatalogo.get(i).getMuebles().get(j).venderMueble();// vendemos los muebles
                // obtenemos todas la ventas que hemos hecho
                todasLasVentas = listaCatalogo.get(i).getMuebles().get(j).getVentas();
                listaVentas.addAll(todasLasVentas);// anyadimos nuestras ventas
            }
        }
    }

    /**
     * generador de catalogos
     */

    private List<Catalogo> randomCatalogos(int cantidadCatalogo, int cantidadMueble) {
        listaCatalogo = new ArrayList<>(cantidadCatalogo);
        Etipo nombre = Etipo.INVIERNO;
        for (int i = 0; i < cantidadCatalogo; i++) {
            nombre = nombre.getRandom();
            int anyo = fk.random().nextInt(2000, 2022);
            // creamos nuevos catalogos que tienes mueblesDuplicados en este caso asignamos
            // el numero
            // deseado de mueblesDuplicados para cada catalago.
            catalogoActual = new Catalogo(nombre, anyo, mueblesDuplicados(cantidadMueble));
            listaCatalogo.add(catalogoActual);
        }

        return (listaCatalogo);
    }

    /**
     * 
     * @return una lista random de mueblesDuplicados
     */
    private List<Mueble> mueblesDuplicados(int cantidad) {
        randomMuebles(cantidad);// generamos los mueblesDuplicados
        List<Mueble> lista = new ArrayList<>(2);
        for (int i = 0; i < 2; i++) {// solo asignamos 2 mueblesDuplicados por catalogo
            muebleActual = listaMueble.get(Util.random(0, listaMueble.size()));
            lista.add(muebleActual);
        }
        return lista;
    }

    /**
     * generador de Muebles
     */
    private List<Mueble> randomMuebles(int cantidad) {
        listaMueble = new ArrayList<>(cantidad);
        for (int i = 0; i < cantidad / 2; i++) {
            String nombre = fk.funnyName().name();
            double precio = fk.number().randomDouble(2, 50, 100);
            double alto = fk.number().randomDouble(2, 5, 50);
            double ancho = fk.number().randomDouble(2, 50, 100);
            double profundo = fk.number().randomDouble(2, 50, 100);
            int stock = fk.random().nextInt(1, 10);
            double peso = fk.number().randomDouble(2, 10, 60);
            String tipoMadera = fk.animal().name();
            muebleActual = new MuebleClasico(nombre, precio, alto, ancho, profundo, stock, peso, tipoMadera);
            listaMueble.add(muebleActual);
        }
        for (int i = 0; i < MAX_MUEBLES / 2; i++) {
            String nombre = fk.funnyName().name();
            double precio = fk.number().randomDouble(2, 50, 100);
            double alto = fk.number().randomDouble(2, 5, 50);
            double ancho = fk.number().randomDouble(2, 50, 100);
            double profundo = fk.number().randomDouble(2, 50, 100);
            int stock = fk.random().nextInt(1, 10);
            String color = fk.color().name();
            muebleActual = new MuebleAux(nombre, precio, alto, ancho, profundo, stock, color);
            listaMueble.add(muebleActual);
        }
        return listaMueble;

    }

    // *GESTION DEL STOCK

    // !PRIVATE METODOS PARA LA GESTION DEL STOCK

    private Catalogo buscarCatalogo(int id) {
        for (Catalogo c : getCatalagos()) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    private Mueble buscarMueble(int idMueble) {

        for (Mueble m : catalogoActual.getMuebles()) {
            // esto lo pongo asi porque me da pereza escribir todo el string porque
            // simplemente lloamando la clase override de equals bastaria y fuese mas
            // entendible.
            if (m.getCodigo().equalsIgnoreCase("C00" + idMueble)) {
                return m;
            }
        }
        return null;
    }

    // !PUBLIC METODOS PARA LA GESTION DEL STOCK

    public void ordenarCatalagos() {
        listaCatalogo.sort(new Catalogo.CompararPorAnyo());
        System.out.println(listaCatalogo);
    }

    public void ordenarMuebles() {
        catalogoActual.getMuebles().sort(new Mueble.CompararPorNombre());
        System.out.println(catalogoActual);

    }

    public void ordenarVentas() {
        getListaVentas().sort(new Venta.ordenarVentasPorAnyo());
        System.out.println(listaVentas);
    }

    public boolean setCatalogoSeleccionado(int id) {
        catalogoActual = buscarCatalogo(id);
        return catalogoActual != null;
    }

    public boolean setMuebleSeleccionado(int id) {
        muebleActual = buscarMueble(id);
        return muebleActual != null;
    }

    public List<Mueble> clasificarTipo(int tipo) {
        Set<Mueble> mueblesSet = new HashSet<Mueble>();
        List<Mueble> muebles = new ArrayList<>();
        // Iterator<Mueble> iterator = mueblesSet.iterator();
        if (tipo == 0) {
            for (int i = 0; i < listaCatalogo.size(); i++) {
                for (int j = 0; j < listaCatalogo.get(i).getMuebles().size(); j++) {
                    if (MuebleClasico.class == listaCatalogo.get(i).getMuebles().get(j).getClass()) {
                        Mueble muebleEncontrado = listaCatalogo.get(i).getMuebles().get(j);
                        mueblesSet.add(muebleEncontrado);// no admite duplicados
                    }
                }
            }
        } else {
            for (int i = 0; i < listaCatalogo.size(); i++) {
                for (int j = 0; j < listaCatalogo.get(i).getMuebles().size(); j++) {
                    if (MuebleAux.class == listaCatalogo.get(i).getMuebles().get(j).getClass()) {
                        Mueble muebleEncontrado = listaCatalogo.get(i).getMuebles().get(j);
                        mueblesSet.add(muebleEncontrado);// no admite duplicados
                    }
                }
            }
        }
        for (Mueble mueble : mueblesSet) {
            muebles.add(mueble);
        }
        muebles.sort(new Mueble.OrdenarPorCodigo());
        return muebles;
    }

    // Recolecta todos los muebles que estan en los catalogos.
    public List<Mueble> totalMuebles() {
        List<Mueble> muebles = new ArrayList<>();
        for (int i = 0; i < listaCatalogo.size(); i++) {
            for (int j = 0; j < listaCatalogo.get(i).getMuebles().size(); j++) {
                muebles.add(listaCatalogo.get(i).getMuebles().get(j));
            }
        }
        return muebles;
    }

    @Override
    public double mediaPrecioMuebles() {
        double costeTotal = 0;
        List<Mueble> muebles = totalMuebles();
        for (int i = 0; i < muebles.size(); i++) {
            costeTotal += muebles.get(i).getPrecio();
        }
        return costeTotal / muebles.size();
    }

    @Override
    public Mueble muebleMasVendido() {
        List<Mueble> muebles = totalMuebles();
        Mueble mueble = muebles.get(1);
        for (int i = 0; i < muebles.size(); i++) {
            if (mueble.getVentas().size() < muebles.get(i).getVentas().size()) {
                mueble = muebles.get(i); // dame el mueble que mas registros de ventas tiene.
            }
        }
        return mueble;
    }

}
