package Tema11.Propios.ejercicio05.models;

import Tema11.Propios.ejercicio05.Control.ControlMax;

public class Element extends Inventary {

    private int newElement;
    private objNames objName;

    public Element() {
        super();
    }

    public Element(objNames objName, int element) {
        // super(ControlMax.checkMax16(element));
        super(objName, element);
    }

    @Override
    public int addElement(objNames objName, int newElement) {
        if ((objName.equals(objNames.PERL)) || (objName.equals(objNames.EGG))) {
            if (ControlMax.checkMax16(newElement) > 0) {
                return super.addElement(objName, newElement);
            }
        }
        if ((objName.equals(objNames.ROCK)) || (objName.equals(objNames.WOOD))) {
            if (ControlMax.checkMax64(newElement) > 0) {
                return super.addElement(objName, newElement);
            }
        }

        if ((objName.equals(objNames.SWORD)) || (objName.equals(objNames.PEAK))) {
            if (ControlMax.checkMax1(newElement) > 0) {
                return super.addElement(objName, newElement);
            }
        }

        System.out.println("Error adding the elements, u cannot surpass the maximum value for this item");
        return -1;

    }

    public objNames getName() {
        super.name = objName;
        return super.getName();
    }

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
