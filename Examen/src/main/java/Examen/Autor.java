package Examen;

public class Autor {

    public static int contID = 0;
    // Atributos de la clase autor
    private String nombre;
    private String apellidos;
    private int autoIdentificador;

    public Autor(String nombre, String apellidos) {
        this.autoIdentificador++;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public long getAutoIdentificador() {
        return autoIdentificador;
    }

    public void setAutoIdentificador(int autoIdentificador) {
        this.autoIdentificador = autoIdentificador;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", autoIdentificador=" + autoIdentificador +
                '}';
    }
}
