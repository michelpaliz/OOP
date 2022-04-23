package Tema11.Propios.ejercicio05.models;

import Tema11.Propios.ejercicio05.Control.ControlMax;

public class Sword extends Craft {

    public Sword() {
        super();
    }

    public Sword(int element) {
        super(ControlMax.checkMax1(element));
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
        return "Sword" + super.toString();
    }

}
