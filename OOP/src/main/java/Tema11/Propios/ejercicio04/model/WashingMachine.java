package Tema11.Propios.ejercicio04.model;

public class WashingMachine extends Appliance {

    private double charge;

    public WashingMachine() {
        this.charge = 5;
    }

    public WashingMachine(double weight, char price) {
        super(price, weight);

    }

    public WashingMachine(double charge, double weight, char price) {
        super(price, weight);
        this.charge = charge;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    @Override
    public double finalPrice() {
        double precioFinal = getPrice();
        if (this.charge > 30) {
            precioFinal += (50);
        }
        return precioFinal;
    }

}
