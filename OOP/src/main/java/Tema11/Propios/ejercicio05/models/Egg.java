package Tema11.Propios.ejercicio05.models;

import Tema11.Propios.ejercicio05.Control.ControlMax;

public class Egg extends Inventary {
    private int element = 0;
    private String name;

    public Egg() {
        super();
        this.name = "Egg";
    }

    public Egg(int element) {
        super(ControlMax.checkMax16(element));
        this.name = "Egg";
    }

    @Override
    public int addElement(int newElement) {
        if (ControlMax.checkMax16(element) > 0) {
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
        return name + super.toString();
    }

}
