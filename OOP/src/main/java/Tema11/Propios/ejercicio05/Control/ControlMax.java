package Tema11.Propios.ejercicio05.Control;

import Tema11.Propios.ejercicio05.models.Inventary;
import Tema11.Propios.ejercicio05.models.objNames;

public class ControlMax extends Inventary {
    static final int max1 = 1;
    static final int max16 = 16;
    static final int max64 = 64;


    public  int addElement(objNames objName, int newElement) {
        if ((objName.equals("perl")) || (objName.equals("egg"))) {
            if (ControlMax.checkMax16(newElement) > 0) {
                return super.addElement(objName, newElement);
            }
        }
        if ((objName.equals("rock")) || (objName.equals("wood"))) {
            if (ControlMax.checkMax64(newElement) > 0) {
                return super.addElement(objName, newElement);
            }
        }

        if ((objName.equals("sword")) || (objName.equals("peak"))) {
            if (ControlMax.checkMax1(newElement) > 0) {
                return super.addElement(objName, newElement);
            }
        }

        System.out.println("Error adding the elements, u cannot surpass the maximum value for this item");
        return -1;

    }

    public static int checkMax16(int number) {
        try {
            if (number <= max16) {
                return number;
            }
        } catch (ExceptionInInitializerError e) {
            System.out.println(e);
            System.out.println("You cannot surpass the maximum size ");
        }
        return -1;

    }

    public static int checkMax64(int number) {
        try {
            if (number <= max64) {
                return number;
            }
        } catch (ExceptionInInitializerError e) {
            System.out.println(e);
            System.out.println("You cannot surpass the maximum size ");
        }
        return -1;

    }

    public static int checkMax1(int number) {
        try {
            if (number <= max1) {
                return number;
            }
        } catch (ExceptionInInitializerError e) {
            System.out.println(e);
            System.out.println("You cannot surpass the maximum size ");
        }
        return -1;

    }

}
