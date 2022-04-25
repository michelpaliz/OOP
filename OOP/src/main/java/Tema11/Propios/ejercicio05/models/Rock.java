package Tema11.Propios.ejercicio05.models;

import Tema11.Propios.ejercicio05.Control.ControlMax;

public class Rock extends Inventary {

    private int element;
    private String objName;

    public Rock() {
        super();
        this.objName = "Rock";
    }

    // public Rock(int element) {
    //     super(ControlMax.checkMax64(element));
    //     this.objName = "Rock";
    // }

    // @Override
    // public int addElement(int newElement) {
    //     if (ControlMax.checkMax64(element) > 0) {
    //         return super.addElement(newElement);
    //     }
    //     System.out.println("Error adding the elements, u cannot surpass the maximum value for this item");
    //     return -1;
    // }

    @Override
    public int removeElement(int numElement) {
        return super.removeElement(numElement);
    }

    // public String getName() {
    //     super.name = objName;
    //     return super.getName();
    // }

    @Override
    public String toString() {
        return objName + super.toString();
    }

}
