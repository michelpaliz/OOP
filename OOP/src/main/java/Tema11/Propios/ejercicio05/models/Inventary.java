package Tema11.Propios.ejercicio05.models;

public class Inventary {

    private int element;
    protected objNames name;

    // in case we do not want to specify the retrivent of a number of elements
    public Inventary() {
        this.element = element + 1;
        this.name = getName();
    }

    // this is to initilizate the element for each craft
    public Inventary(objNames names, int element) {
        this.element = element;
        this.name = names;
    }

    // this is the constructor to add the array's values to the 2d array
    // public <T> Inventary(T key) {
    // this.element = ((Inventary) key).getElement();
    // this.name = ((Inventary) key).getName();
    // }

    public Inventary(Element key) {
        this.element = (key).getElement();
        this.name = (key).getName();
    }

    protected objNames getName() {
        return name;
    }

    public int getElement() {
        return element;
    }

    public int removeElement(int numElement) {
        return element -= numElement;
    }

    public int addElement(objNames objName, int newElement) {
        this.name = objName;
        return this.element += newElement;
    }

    @Override
    public String toString() {
        return "[" + getName() + " " + element + "]";
    }

}
