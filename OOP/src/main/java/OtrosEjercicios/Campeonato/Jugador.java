package OtrosEjercicios.Campeonato;

public class Jugador {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private POSICION posicion;

    public enum POSICION {
        DELANTERO, MEDIOCAMPISTA, DEFENSA, PORTERO
    }


}
