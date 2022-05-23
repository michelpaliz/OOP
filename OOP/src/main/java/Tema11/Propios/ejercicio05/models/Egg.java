package Tema11.Propios.ejercicio05.models;

import Tema11.Propios.ejercicio05.Control.ControlMax;

public class Egg extends Inventary {
    // private final String name = "Egg";

    private int element;
    private String objName;

    public Egg() {
        super();
        this.objName = "Egg";
    }

    // public Egg(int element) {
    //     super(ControlMax.checkMax16(element));
    //     this.objName = "Egg";
    // }

    // @Override
    // public int addElement(int newElement) {
    //     if (ControlMax.checkMax16(element) > 0) {
    //         return super.addElement(newElement);
    //     }
    //     System.out.println("Error adding the elements, u cannot surpass the maximum value for this item");
    //     return -1;

    // }

    // public String getName() {
    //     super.name = objName;
    //     return super.getName();
    // }

    @Override
    public int removeElement(int numElement) {
        return super.removeElement(numElement);
    }

    // this toString only prints out the subclass in this case egg
    @Override
    public String toString() {
        return objName + super.toString();
    }

}
