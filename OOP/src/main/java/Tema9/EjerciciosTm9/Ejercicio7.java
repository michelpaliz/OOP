package Tema9.EjerciciosTm9;

public class Ejercicio7 {

    public static void Ejercicio7() {

        String array[] = { "hola", "buenas", "tardes", null };
        mostrarCadenasArray(array);
    }

    public static void mostrarCadenasArrayCorregido(String[] array) {
        // si el metodo es null no seguira
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            // con esto evitamos que se produzca un nullpointerexecption
            if (array[i] != null)
                System.out.println(array[i].charAt(0));
        }

    }

    public static void mostrarCadenasArray(String[] array) {
        try {
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i].charAt(0));
            }
        } catch (NullPointerException e) {
            System.out.println("La matriz debe de estar inicializad");
        }
    }

}
