package Tema11.Propios.ejercicio05.models;

import Tema11.Propios.ejercicio05.Control.ControlMax;

public class Egg extends Craft {
    private final int max = 16;
    private int element = 0;

    public Egg() {
        super();
    }

    public Egg(int element) {
        super(ControlMax.checkMax(element));
    }

    @Override
    public int addElement(int newElement) {
        if (ControlMax.checkMax(element) > 0) {
            return super.addElement(newElement);
        }
        System.out.println("Error adding the elements, u cannot surpass the maximum value for this item");
        return -1;

    }

    @Override
    public int removeElement(int numElement) {
        return super.removeElement(numElement);
    }

    @Override
    public String toString() {
        return "Egg" + super.toString();
    }

    // @Override
    // public int checkMax() {
    // if (element <= max) {
    // return element;
    // }
    // System.out.println("You cannot surpass the maximum size ");
    // return -1;
    // }

}
