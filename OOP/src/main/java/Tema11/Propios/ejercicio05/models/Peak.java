package Tema11.Propios.ejercicio05.models;

public class Peak extends Craft {
    private int element = 0;

    public Peak() {
        super();
    }

    public Peak(int element) {
        super(element);
    }

    @Override
    public int addElement(int newElement) {
        // TODO Auto-generated method stub
        return super.addElement(newElement);
    }

    @Override
    public int removeElement(int numElement) {
        // TODO Auto-generated method stub
        return super.removeElement(numElement);
    }

    public String toString() {
        return "Peak" + super.toString();
    }

}
