package OtrosEjercicios.Campeonato;

public class Jugador {
    // creacion de atributos
    private final String id;
    private final String nombre;
    private final String apellido;
    private final int edad;
    private Posicion posicion;

    public Jugador(String id, String nombre, String apellido, int edad, Posicion posicion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.posicion = posicion;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Jugador [apellido=" + apellido + ", edad=" + edad + ", id=" + id + ", nombre=" + nombre + ", posicion="
                + posicion + "]";
    }

}
