package Tema11.Propios.ejercicio05.models;

public class Craft {

    private int element;

    // in case we do not want to specify the retrivent of a number of elements
    public Craft() {
        this.element = element + 1;
    }

    // this is to initilizate the element for each craft
    public Craft(int element) {
        this.element = element;
    }

    public int getElement() {
        return element;
    }

    public int removeElement(int numElement) {
        return element -= numElement;
    }

    public int addElement(int newElement) {
        return this.element += newElement;
    }

    // public <T> String toString(T obj) {
    //     return obj + " [element=" + element + "]";
    // }

    @Override
    public String toString() {
        return "[element=" + element + "]";
    }


}
