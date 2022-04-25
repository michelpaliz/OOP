package Tema11.Propios.ejercicio05.models;

import Tema11.Propios.ejercicio05.Control.ControlMax;

public class Perl extends Inventary {

    private int element;
    private String objName;

    public Perl() {
        super();
        this.objName = "Pearl";
    }

    // public Perl(int element) {
    //     super(ControlMax.checkMax16(element));
    //     this.objName = "Pearl";
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
