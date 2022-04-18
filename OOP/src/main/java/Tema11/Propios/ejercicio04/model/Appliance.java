package Tema11.Propios.ejercicio04.model;

import java.util.Arrays;

import Util.Control;

// import Util.Ansi;

public class Appliance {

    // private static final String HashMap = null;

    private char[] colorArr = { 'A', 'B', 'C', 'D', 'E', 'F' };
    private final Color D_COLOR = Color.WHITE;
    private final char D_CONSUM = 'F';
    private final double finalPrice = 0;

    private double basePrice;
    private Color color;
    private char electricalConsum;
    private double weight;

    public Appliance() {
        this.basePrice = 100;
        this.color = D_COLOR;
        this.electricalConsum = D_CONSUM;
        this.weight = 5;
    }

    public Appliance(double basePrice, double weight) {
        this.basePrice = basePrice;
        this.color = D_COLOR;
        this.electricalConsum = D_CONSUM;
        this.weight = weight;

    }

    public Appliance(double basePrice, Color color, char electricalConsum, double weight) {
        this.basePrice = basePrice;
        this.color = color;
        this.electricalConsum = electricalConsum;
        this.weight = weight;
    }

    public double getPrice() {
        return basePrice;
    }

    public char getElectricalConsum() {
        return electricalConsum;
    }

    public double getWeight() {
        return weight;
    }

    public char checkElectricalConsum(char word) {
        if (Control.one(Config.colorArr, word)) {
            return this.electricalConsum = word;
        } else {
            return this.electricalConsum = D_CONSUM;
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
                break;
        }

        if (weight <= 19 && weight > 0) {
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

    @Override
    public String toString() {
        return "Appliance{" +
                "basePrice=" + basePrice +
                ", color=" + color +
                ", electricalConsum=" + electricalConsum +
                ", weight=" + weight;
    }
}
