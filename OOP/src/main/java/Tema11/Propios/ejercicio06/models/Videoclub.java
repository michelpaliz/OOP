package Tema11.Propios.ejercicio06.models;

import java.util.List;

public class Videoclub {

    private List<Multimedia> multimedia;
    private List<Autor> autores;
    private List <Actor> actores;
    private LIst<Socio> socios;

    public Videoclub(List<Multimedia> multimedia, List<Autor> autores, List<Socio> socios) {
        this.multimedia = multimedia;
        this.autores = autores;
        this.socios = socios;
    }   

}
