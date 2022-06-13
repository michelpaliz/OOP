package Tema11.Propios.ejercicio06.models;

import Tema11.Propios.ejercicio06.numeric.Platforma;

public class Videojuego extends Multimedia {
    private Platforma plataforma;

    public Videojuego() {
        super();
        plataforma = Platforma.NINTENDO;
    }

    public Videojuego(Platforma platform) {
        super();
        this.plataforma = platform;
    }

    @Override
    public String toString() {
        return super.toString() + " VideoGame [platform=" + plataforma + "]\n";
    }

}
