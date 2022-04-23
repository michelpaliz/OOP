package Tema11.Propios.ejercicio05.Control;

public class ControlMax {
    static final int max1 = 1;
    static final int max16 = 16;
    static final int max64 = 64;

    public static int checkMax16(int number) {
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

    public static int checkMax64(int number) {
        try {
            if (number <= max64) {
                return number;
            }
        } catch (ExceptionInInitializerError e) {
            System.out.println(e);
            System.out.println("You cannot surpass the maximum size ");
        }
        return -1;

    }

    public static int checkMax1(int number) {
        try {
            if (number <= max1) {
                return number;
            }
        } catch (ExceptionInInitializerError e) {
            System.out.println(e);
            System.out.println("You cannot surpass the maximum size ");
        }
        return -1;

    }

}
