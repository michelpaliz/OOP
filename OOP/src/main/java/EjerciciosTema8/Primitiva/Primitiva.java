package EjerciciosTema8.Primitiva;

import java.util.Arrays;
import java.util.Set;

public class Primitiva {
    // Creacion de atributos
    private int[] numerosElegidos;
    private String modalidadJuego;
    // +Todo generar los tipos de datos para estos dos arrays
    private int[] numReintegro;
    private int[] numeroComp;

    // Generacion de constructores
    public Primitiva(int[] numerosElegidos, String modalidadJuego) {
        this.numerosElegidos = numerosElegidos;
        this.modalidadJuego = modalidadJuego;
    }

    public Primitiva(int[] validarNumeros) {
        this.numerosElegidos = validarNumeros;
    }

    public Primitiva(Set<Integer> generatorRandom) {
        this.numerosElegidos = JuegoPrimitiva.numeros; // para inicializar el atributo con una constante
        int j = 0;
        for (Integer i : generatorRandom) {
            this.numerosElegidos[j++] = i;
        }
    }

    @Override
    public String toString() {
        return "Primitiva{" +
                "numerosElegidos=" + Arrays.toString(numerosElegidos) +
                ", modalidadJuego='" + modalidadJuego + '\'' +
                '}';
    }

}
