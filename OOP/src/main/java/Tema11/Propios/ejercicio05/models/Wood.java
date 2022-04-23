package Tema11.Propios.ejercicio05.models;

import Tema11.Propios.ejercicio05.Control.ControlMax;

public class Wood extends Inventary {

    public Wood() {
        super();
    }

    public Wood(int element) {
        super(ControlMax.checkMax64(element));
    }

    @Override
    public int addElement(int newElement) {
        return super.addElement(newElement);
    }

    @Override
    public int removeElement(int numElement) {
        return super.removeElement(numElement);
    }

    public String toString() {
        return "Peak" + super.toString();
    }

}
