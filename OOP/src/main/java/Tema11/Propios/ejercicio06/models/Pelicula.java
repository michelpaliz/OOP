package Tema11.Propios.ejercicio06.models;

public class Pelicula extends Multimedia {
    private double duracion;
    private String autor;
    private String actriz;

    public Pelicula() {
        super();
        this.duracion = 5.0;
        this.autor = "Michael";
        this.actriz = "Sanyi";
    }

    public Pelicula(double duration, String autor, String actriz) {
        super();
        this.duracion = duration;
        this.autor = autor;
        this.actriz = actriz;
    }

    public double getDuration() {
        return duracion;
    }

    public String getMaleAuthor() {
        return autor;
    }

    public String getFemaleAuthor() {
        return actriz;
    }

    @Override
    public String toString() {
        return super.toString() + " Film [duration=" + duracion + ", femaleAuthor=" + actriz + ", maleAuthor="
                + autor + "]\n";
    }

}
