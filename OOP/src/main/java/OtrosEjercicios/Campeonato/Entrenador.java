package OtrosEjercicios.Campeonato;

public class Entrenador {
    
    // Creacion de atributos
    private final  long id;
    private final  String nombre;
    private final  String apellido;


    public Entrenador(String id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
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


    @Override
    public String toString() {
        return "Entrenador [apellido=" + apellido + ", id=" + id + ", nombre=" + nombre + "]";
    }



}
