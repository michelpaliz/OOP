package EjerciciosTema8.Primitiva;

import java.util.Arrays;
import java.util.Set;

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

    public Primitiva(Set<Integer> generatorRandom) {
        this.numerosSuerte = JuegoPrimitiva.numeros; // para inicializar el atributo con una variable
        int j = 0;
        for (Integer i : generatorRandom) {
            this.numerosSuerte[j++] = i;
        }
    }

    @Override
    public String toString() {
        return "Primitiva{" +
                "numerosSuerte=" + Arrays.toString(numerosSuerte) +
                ", modalidadJuego='" + modalidadJuego + '\'' +
                '}';
    }

}
