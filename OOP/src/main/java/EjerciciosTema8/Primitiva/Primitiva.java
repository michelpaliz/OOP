package EjerciciosTema8.Primitiva;

import java.util.Arrays;

public class Primitiva {
    // Creacion de atributos
    private int[] numerosSuerte;
    private String modalidadJuego;

    // Generacion de constructores
    public Primitiva(int[] numerosSuerte, String modalidadJuego) {
        this.numerosSuerte = numerosSuerte;
        this.modalidadJuego = modalidadJuego;
    }

    public Primitiva(int[] validarNumeros) {
        this.numerosSuerte = validarNumeros;
    }

    @Override
    public String toString() {
        return "Primitiva{" +
                "numerosSuerte=" + Arrays.toString(numerosSuerte) +
                ", modalidadJuego='" + modalidadJuego + '\'' +
                '}';
    }

}
