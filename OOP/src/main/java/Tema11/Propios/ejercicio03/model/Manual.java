package Tema11.Propios.ejercicio03.model;

public class Manual extends Car {

    @Override
    public int chgCurrentGear(int value) {
        if (value < 0) {
            return super.chgCurrentGear(value);
        }
        return -1;
    }

    @Override
    public double breakSpeed(double value) {
        // TODO Auto-generated method stub
        return super.breakSpeed(value);
    }

   

}