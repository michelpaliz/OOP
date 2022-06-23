package Examen.Out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public void name() {

    }

    /**
     * generador de catalogos
     */

    public List<Catalogo> randomCatalogos() {
        Etipo nombre = Etipo.INVIERNO;
        listaCatalogo = new ArrayList<>(MAX_CATALAGOS);
        nombre = nombre.getRandom();
        int anyo = fk.random().nextInt(2000, 2022);
        c = new Catalogo(nombre, anyo, muebles());
        listaCatalogo.add(c);
        return (listaCatalogo);
    }

    /**
     * 
     * @return una lista random de muebles
     */
    public List<Mueble> muebles() {
        randomMuebles();// generamos los muebles
        List<Mueble> lista = new ArrayList<>(2);
        for (int i = 0; i < 2; i++) {// solo asignamos 2 muebles por catalogo
            m = listaMueble.get(Util.random(0, listaMueble.size()));
            lista.add(m);
        }
        return lista;
    }

    /**
     * generador de Muebles
     */
    public List<Mueble> randomMuebles() {
        listaMueble = new ArrayList<>(MAX_MUEBLES);
        for (int i = 0; i < MAX_MUEBLES / 2; i++) {
            String nombre = fk.funnyName().name();
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
            String nombre = fk.funnyName().name();
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
