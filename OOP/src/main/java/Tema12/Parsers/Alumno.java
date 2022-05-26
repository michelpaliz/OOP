package Tema12.Parsers;

public class Alumno extends Person implements Runnable {

    private int num;
    private String nia;
    private final String[] datos;

    public Alumno(String name, String nia, int num, String[] datos) {
        super(name);
        this.nia = nia;
        this.num = num;
        this.datos = datos;
    }
    // runnable nos obliga implementar este metodo,

    public String getNia() {
        return nia;
    }

    @Override
    public void run() {
        for (int i = 0; i < datos.length; i++) {
            datos[i] = datos[i] + super.getName(); // cuando uno entra otra no puede salir?
            System.out.println("Soy el alumno " + getName() + " con el nia " + getNia() + ": " + i);
        }

    }

}
