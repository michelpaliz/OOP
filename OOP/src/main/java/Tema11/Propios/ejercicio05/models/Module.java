package Tema11.Propios.ejercicio05.models;

public interface Module {
    int max16 = 16;

    static int checkMax(int number) {
        if (number <= max16) {
            return number;
        }
        System.out.println("You cannot surpass the maximum size ");
        return -1;
    }

}
