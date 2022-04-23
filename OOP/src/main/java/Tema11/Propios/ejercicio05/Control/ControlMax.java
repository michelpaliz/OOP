package Tema11.Propios.ejercicio05.Control;

public class ControlMax {
    static final int max16 = 16;

    public static int checkMax(int number) {
        try {
            if (number <= max16) {
                return number;
            }
        } catch (ExceptionInInitializerError e) {
            System.out.println(e);
            System.out.println("You cannot surpass the maximum size ");
        }
        return -1;

    }

}
