package Tema11.Propios.ejercicio05.models;

public class Inventary {

    private int element;

    // in case we do not want to specify the retrivent of a number of elements
    public Inventary() {
        this.element = element + 1;
    }

    // this is to initilizate the element for each craft
    public Inventary(int element) {
        this.element = element;
    }

    public <T> Inventary(T key, T value){
            this.
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
