package Tema11.Propios.ejercicio05.models;

import Tema11.Propios.ejercicio05.Control.ControlMax;

public class Perl extends Inventary {

    String name;

    public Perl() {
        super();
        this.name= "Pearl";
    }

    public Perl(int element) {
        super(ControlMax.checkMax16(element));
        this.name= "Pearl";
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
        return name + super.toString();
    }

}
