package Tema11.Propios.ejercicio04.model;

import Util.Control;

// import Util.Ansi;

public class Electrodomestico {

    private char[] color = { 'A', 'B', 'C', 'D', 'E', 'F' };

    private double price;
    // private Ansi color;
    private char electricalConsum;
    private double weight;

    public Electrodomestico() {
        this.price = 100;
        this.electricalConsum = 'F';
        this.weight = 5;
    }

    public Electrodomestico(double price, double weight) {
        this.price = price;
        this.weight = weight;
    }

    public Electrodomestico(double price, char electricalConsum, double weight) {
        this.price = price;
        this.electricalConsum = electricalConsum;
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public double checkPrice(char word, double weight) {

        switch (word) {
            case 'A':
                this.price = 100;
                break;
            case 'B':
                this.price = 80;
                break;
            case 'C':
                this.price = 60;
                break;
            case 'D':
                this.price = 50;
                break;
            case 'E':
                this.price = 30;
                break;
            case 'F':
                this.price = 10;
        }

        return electricalConsum;

    }

}
