package Examen.Out;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;

import Examen.Models.Catalogo;
import Examen.Models.Maux;
import Examen.Models.Mclasico;
import Examen.Models.Mueble;
import Examen.numeric.Enombre;
import TestWorlde.Propio.main;

public class Inventario {
    Faker fk = new Faker();
    private int numMuebles = 20;
    private int numCatalogos = 10;
    private List<Mueble> listaMueble;
    private List<Catalogo> listaCatalogo;
    private Catalogo c;
    private Mueble m;
    private Mclasico mClasico;
    private String user;

    public Inventario() {
        //crea nuevos muebles
        gnRandom();
        //crea nuevos catalgos
        gnRandomC();
    }

    /**
     * generado de catalogos
     */

    public List<Catalogo> gnRandomC() {
        listaCatalogo = new ArrayList<>(numCatalogos);
        Enombre nombre = Enombre.INVIERNO;
        for (int i = 0; i < numCatalogos; i++) {
            nombre = nombre.getRandom();
            int anyo = fk.random().nextInt(2000, 2022);
            m = listaMueble.get(i);
            c = new Catalogo(nombre, anyo, m);
            listaCatalogo.add(c);
        }
        return (listaCatalogo);
    }

    /**
     * generador de Muebles
     */
    public List<Mueble> gnRandom() {
        listaMueble = new ArrayList<>(numMuebles);
        Enombre nombre = Enombre.INVIERNO;
        for (int i = 0; i < numMuebles / 2; i++) {
            nombre = nombre.getRandom();
            double precio = fk.random().nextDouble();
            double alto = fk.random().nextDouble();
            double ancho = fk.random().nextDouble();
            double profundo = fk.random().nextDouble();
            int stock = fk.random().nextInt(1, 10);
            double peso = fk.random().nextDouble();
            String tipoMadera = fk.animal().name();
            String color = fk.color().name();
            m = new Mclasico(nombre, precio, alto, ancho, profundo, stock, peso, tipoMadera);
            listaMueble.add(m);
        }
        for (int i = 0; i < numMuebles / 2; i++) {
            nombre = nombre.getRandom();
            double precio = fk.random().nextDouble();
            double alto = fk.random().nextDouble();
            double ancho = fk.random().nextDouble();
            double profundo = fk.random().nextDouble();
            int stock = fk.random().nextInt(1, 10);
            double peso = fk.random().nextDouble();
            String tipoMadera = fk.animal().name();
            String color = fk.color().name();
            m = new Maux(nombre, precio, alto, ancho, profundo, stock, color);
            listaMueble.add(m);
        }
        return listaMueble;

    }

}
