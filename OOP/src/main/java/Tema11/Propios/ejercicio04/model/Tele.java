package Tema11.Propios.ejercicio04.model;

public class Tele extends Appliance {

    private static final int R_VALUE = 20;
    private static final boolean S_VALUE = false;

    private double resolution;
    private boolean smartTv;

    public Tele() {
        super();
        this.resolution = 20;
        this.smartTv = false;
    }

    public Tele(double price, double weight) {
        super(price, weight);
        this.resolution = R_VALUE;
        this.smartTv = S_VALUE;
    }

    public Tele(double resolution, boolean smartTv, Color color, char electricalConsum, double weight, char price) {
        super(price, color, electricalConsum, weight);
        this.resolution = resolution;
        this.smartTv = smartTv;
    }

    public double getResolution() {
        return resolution;
    }

    public boolean isSmartTv() {
        return smartTv;
    }

    @Override
    public double finalPrice() {
        double finalPrice = getPrice();
        if (this.resolution > 40) {
            finalPrice += (30 * finalPrice) / 100;
        }
        if (this.smartTv == true) {
            finalPrice += 50;
        }
        return finalPrice;

    }

}
