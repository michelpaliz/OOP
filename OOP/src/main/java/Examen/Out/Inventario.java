package Examen.Out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.github.javafaker.Faker;

import Examen.Models.Catalogo;
import Examen.Models.MuebleAux;
import Examen.Models.MuebleClasico;
import Examen.numeric.Etipo;
import Examen.Models.Mueble;
import Lib.Util;

public class Inventario {
    private static Faker fk = new Faker();
    private final int MAX_MUEBLES = 20;
    private final int MAX_CATALAGOS = 3;
    protected List<Mueble> listaMueble;
    protected List<Catalogo> listaCatalogo;
    private Catalogo catalogoActual;
    private Mueble muebleActual;

    public Inventario() {
        randomCatalogos(MAX_CATALAGOS, MAX_MUEBLES);
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

    /**
     * generador de catalogos
     */

    public List<Catalogo> randomCatalogos(int cantidadCatalogo, int cantidadMueble) {
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
    public List<Mueble> mueblesDuplicados(int cantidad) {
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
    public List<Mueble> randomMuebles(int cantidad) {
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

    public void ordenarCatalagos() {
        listaCatalogo.sort(new Catalogo.CompararPorAnyo());
        System.out.println(listaCatalogo);
    }

    public void ordenarMuebles() {
        catalogoActual.getMuebles().sort(new Mueble.CompararPorNombre());
        System.out.println(catalogoActual);

    }

    public boolean setCatalogoSeleccionado(int id) {
        catalogoActual = buscarCatalogo(id);
        return catalogoActual != null;
    }

    public boolean setMuebleSeleccionado(int id) {
        muebleActual = buscarMueble(id);
        return muebleActual != null;
    }

    private Catalogo buscarCatalogo(int id) {
        getListaMueble();
        for (Catalogo c : getCatalagos()) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    private Mueble buscarMueble(int idMueble) {

        for (Mueble m : catalogoActual.getMuebles()) {
            if (m.getCodigo().equalsIgnoreCase("C00" + idMueble)) {
                return m;
            }
        }
        return null;
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
        System.out.println(muebles.size());
        return muebles;
    }

}
