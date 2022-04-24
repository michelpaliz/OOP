package Tema11.Propios.ejercicio05.models;

public class Inventary {

    private int element;
    protected String name;

    // in case we do not want to specify the retrivent of a number of elements
    public Inventary() {
        this.element = element + 1;
        this.name = getName();
    }

    // this is to initilizate the element for each craft
    public Inventary(int element) {
        this.element = element;
        this.name = getName();
    }

    // this is the constructor to add the array's values to the 2d array
    public <T> Inventary(T key) {
        this.element = ((Inventary) key).getElement();
        this.name = ((Inventary) key).getName();
    }

    protected String getName() {
        return name;
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

    @Override
    public String toString() {
        return "[" + getName() + " " + element + "]";
    }

}
