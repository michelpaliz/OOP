package Tema11.Propios.ejercicio05.models;

import Tema11.Propios.ejercicio05.Control.ControlMax;

public class Rock extends Craft {

    public Rock() {
        super();
    }

    public Rock(int element) {
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
        return "Rock" + super.toString();
    }

}
