package Tema11.Propios.ejercicio3.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Car {

    private final int MAX_SIZE = 5;

    private String licensePlate;
    private double currentSpeed;
    private int currentGear;
    private ArrayList<Integer> maxSpeed;

    // 30 , 60 , 100 , 140, 195

    public Car() {
        this.licensePlate = null;
        this.currentSpeed = 0;
        this.currentGear = 0;
        this.maxSpeed = new ArrayList<Integer>(MAX_SIZE);
    }

    public Car(String licensePlate, ArrayList<Integer> SPEED) {
        this.licensePlate = licensePlate;
        this.currentSpeed = 0;
        this.currentGear = 0;
        this.maxSpeed = SPEED;
    }

    public Car(String licensePlate, double currenSpeed, int currentGear, ArrayList<Integer> maxSpeed) {
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

    public ArrayList<Integer> getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(ArrayList<Integer> maxSpeed) {
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

    protected double gear() {
        for (int i = 0; i < maxSpeed.size(); i++) {
            if (this.currentSpeed == maxSpeed.get(i)) {
                setCurrentGear(maxSpeed.indexOf(i));
            } else if (this.currentSpeed > maxSpeed.get(i) && this.currentSpeed <= maxSpeed.get(i)) {
                setCurrentGear(maxSpeed.indexOf(i));
            }
        }
        return this.currentSpeed;
    }

    @Override
    public String toString() {
        return "Car [ CurrenSpeed=" + currentSpeed + ", currentGear="
                + currentGear
                + ", licensePlate=" + licensePlate + ", maxSpeed=" + Arrays.toString(maxSpeed) + "]";
    }

}
