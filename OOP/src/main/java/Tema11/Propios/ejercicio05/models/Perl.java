package Tema11.Propios.ejercicio05.models;

import Tema11.Propios.ejercicio05.Control.ControlMax;

public class Perl extends Craft {

    public Perl() {
        super();
    }

    public Perl(int element) {
        super(ControlMax.checkMax16(element));
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
        return "Perl" + super.toString();
    }

}
