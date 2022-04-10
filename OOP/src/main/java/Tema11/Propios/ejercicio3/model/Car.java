package Tema11.Propios.ejercicio3.model;

import java.util.Arrays;

public class Car {

    private final int MAX_SIZE = 5;

    private String licensePlate;
    private double currentSpeed;
    private int currentGear;
    private int[] maxSpeed;

    // 30 , 60 , 100 , 140, 195

    public Car() {
        this.licensePlate = null;
        this.currentSpeed = 0;
        this.currentGear = 0;
        this.maxSpeed = new int[MAX_SIZE];
    }

    public Car(String licensePlate, int[] speed) {
        this.licensePlate = licensePlate;
        this.currentSpeed = 0;
        this.currentGear = 0;
        this.maxSpeed = speed;
    }

    public Car(String licensePlate, double currenSpeed, int currentGear, int[] maxSpeed) {
        this.licensePlate = licensePlate;
        this.currentSpeed = currenSpeed;
        this.currentGear = currentGear;
        this.maxSpeed = maxSpeed;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public double getCurrenSpeed() {
        return currentSpeed;
    }

    public void setCurrenSpeed(double currenSpeed) {
        this.currentSpeed = currenSpeed;
    }

    public int getCurrentGear() {
        return currentGear;
    }

    public void setCurrentGear(int currentGear) {
        this.currentGear = currentGear;
    }

    public int[] getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int[] maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    // new we add some basic features for our car

    public double speedUp(double value) {
        return this.currentSpeed += value;
    }

    public double breakSpeed(double value) {
        return this.currentSpeed = value;
    }

    protected int chgCurrentGear(int value) {
        return this.currentGear = value;
    }

    @Override
    public String toString() {
        return "Car [MAX_SIZE=" + MAX_SIZE + ", currenSpeed=" + currentSpeed + ", currentGear=" + currentGear
                + ", licensePlate=" + licensePlate + ", maxSpeed=" + Arrays.toString(maxSpeed) + "]";
    }

}
