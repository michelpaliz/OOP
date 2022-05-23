package Tema11.Propios.ejercicio04.model;

public class WashingMachine extends Appliance {

    private static final int DEF_CAP = 5;

    private double charge;

    public WashingMachine() {
        super();
        this.charge = DEF_CAP;
    }

    public WashingMachine(double weight, char price) {
        super(price, weight);
        this.charge = DEF_CAP;
    }

    public WashingMachine(double charge, Color color, char electricalConsum, double weight, double price) {
        super(price, color, electricalConsum, weight);
        this.charge = charge;
    }

    public double getCharge() {
        return charge;
    }

    @Override
    public double finalPrice() {
        double finalPrice = getPrice();
        if (this.charge > 30) {
            finalPrice += (50);
        }
        return finalPrice;
    }

    public String toString() {
        return super.toString() + " ,charge " + charge + '}' + "\n";
    }

}
