package Examen.Out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.github.javafaker.Faker;

import Examen.Models.Catalogo;
import Examen.Models.MuebleAux;
import Examen.Models.MuebleClasico;
import Examen.Models.Mueble;
import Examen.numeric.Enombre;
import Lib.Util;

public class Inventario {
    private static Faker fk = new Faker();
    private final int MAX_MUEBLES = 20;
    private final int MAX_CATALAGOS = 3;
    protected List<Mueble> listaMueble;
    private List<Catalogo> listaCatalogo;
    private Catalogo c;
    private Mueble m;
    private MuebleClasico mClasico;
    private String user;

    public Inventario() {
        // crea nuevos catalgos
        for (int i = 0; i < MAX_CATALAGOS; i++) {
            System.out.println(randomCatalogos());
        }

    }

    /**
     * 
     * @return una lista random de muebles
     */
    public List<Mueble> muebles() {
        randomMuebles();// generamos muebles
        List<Mueble> lista = new ArrayList<>(2);
        for (int i = 0; i < 2; i++) {
            m = listaMueble.get(Util.random(0, listaMueble.size()));
            lista.add(m);
        }
        // System.out.println("ESTO ES LISTA");
        // System.out.println(lista);
        return lista;
    }

    /**
     * generado de catalogos
     */

    public List<Catalogo> randomCatalogos() {
        Enombre nombre = Enombre.INVIERNO;
        listaCatalogo = new ArrayList<>(MAX_CATALAGOS);
        nombre = nombre.getRandom();
        int anyo = fk.random().nextInt(2000, 2022);
        c = new Catalogo(nombre, anyo, muebles());
        listaCatalogo.add(c);
        return (listaCatalogo);
    }

    /**
     * generador de Muebles
     */
    public List<Mueble> randomMuebles() {
        listaMueble = new ArrayList<>(MAX_MUEBLES);
        Enombre nombre = Enombre.INVIERNO;
        for (int i = 0; i < MAX_MUEBLES / 2; i++) {
            nombre = nombre.getRandom();
            double precio = fk.number().randomDouble(2, 50, 100);
            double alto = fk.number().randomDouble(2, 5, 50);
            double ancho = fk.number().randomDouble(2, 50, 100);
            double profundo = fk.number().randomDouble(2, 50, 100);
            int stock = fk.random().nextInt(1, 10);
            double peso = fk.number().randomDouble(2, 10, 60);
            String tipoMadera = fk.animal().name();
            String color = fk.color().name();
            m = new MuebleClasico(nombre, precio, alto, ancho, profundo, stock, peso, tipoMadera);
            listaMueble.add(m);
        }
        for (int i = 0; i < MAX_MUEBLES / 2; i++) {
            nombre = nombre.getRandom();
            double precio = fk.number().randomDouble(2, 50, 100);
            double alto = fk.number().randomDouble(2, 5, 50);
            double ancho = fk.number().randomDouble(2, 50, 100);
            double profundo = fk.number().randomDouble(2, 50, 100);
            int stock = fk.random().nextInt(1, 10);
            double peso = fk.number().randomDouble(2, 10, 60);
            String tipoMadera = fk.animal().name();
            String color = fk.color().name();
            m = new MuebleAux(nombre, precio, alto, ancho, profundo, stock, color);
            listaMueble.add(m);
        }
        return listaMueble;

    }

}
