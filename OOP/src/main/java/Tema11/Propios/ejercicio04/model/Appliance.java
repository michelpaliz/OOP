package Tema11.Propios.ejercicio04.model;

import Util.Control;

// import Util.Ansi;

public class Appliance {

    // private static final String HashMap = null;

    private char[] color = { 'A', 'B', 'C', 'D', 'E', 'F' };

    private final double finalPrice = 0;

    private double basePrice;
    // private Ansi color;
    private char electricalConsum;
    private double weight;

    public Appliance() {
        this.basePrice = 100;
        this.electricalConsum = 'F';
        this.weight = 5;
    }

    public Appliance(double price, double weight) {
        this.basePrice = price;
        this.weight = weight;
    }

    public Appliance(double price, char electricalConsum, double weight) {
        this.basePrice = price;
        this.electricalConsum = electricalConsum;
        this.weight = weight;
    }

    public double getPrice() {
        return basePrice;
    }

    public void setPrice(double price) {
        this.basePrice = price;
    }

    public char getElectricalConsum() {
        return electricalConsum;
    }

    public void setElectricalConsum(char electricalConsum) {
        this.electricalConsum = electricalConsum;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public char checkElectricalConsum(char word) {
        if (Control.one(color, word)) {
            return this.electricalConsum = word;
        } else {
            return this.electricalConsum = 'F';
        }

    }

    // ahora puedo llamar el final price desde electrodomestico desde otras
    // subclases.
    public double finalPrice() {
        double finalPrice = basePrice;
        switch (electricalConsum) {
            case 'A':
                finalPrice += 100;
                break;
            case 'B':
                finalPrice += 80;
                break;
            case 'C':
                finalPrice += 60;
                break;
            case 'D':
                finalPrice += 50;
                break;
            case 'E':
                finalPrice += 30;
                break;
            case 'F':
                finalPrice += 10;
        }

        if (weight <= 19) {
            finalPrice += 10;
        } else if (weight >= 20 && weight < 49) {
            finalPrice += 50;
        } else if (weight >= 50 && weight <= 79) {
            finalPrice += 80;
        } else if (weight > 80) {
            finalPrice += 100;
        }

        return finalPrice;

    }

}
