package Tema9.EjerciciosTm9;

public class Ejercicio7 {

    public static void Ejercicio7() {

        String array[] = { "hola", "buenas", "tardes" };
        mostrarCadenasArray(array);
    }

    public static void mostrarCadenasArray(String[] array) {

        try {
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i].charAt(0));
            }
        } catch (NullPointerException e) {
            System.out.println("La matriz debe de estar inicializada");
        }
    }

}
