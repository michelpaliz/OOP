package Tema11.Propios.ejercicio3.model;

public class Manual extends Car {

    @Override
    public int chgCurrentGear(int value) {
        if (value < 0) {
            return super.chgCurrentGear(value);
        }
        return -1;
    }

}