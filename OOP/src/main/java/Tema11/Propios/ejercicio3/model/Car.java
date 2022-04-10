package Tema11.Propios.ejercicio3.model;

import java.util.ArrayList;

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

    public Car(String licensePlate, ArrayList<Integer> arrayList) {
        this.licensePlate = licensePlate;
        this.currentSpeed = 0;
        this.currentGear = 0;
        this.maxSpeed = arrayList;
    }

    // public Car(String licensePlate, double currenSpeed, int currentGear,
    // ArrayList<Object> maxSpeed) {
    // this.licensePlate = licensePlate;
    // this.currentSpeed = currenSpeed;
    // this.currentGear = currentGear;
    // this.maxSpeed = maxSpeed;
    // }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public double getCurrenSpeed() {
        return this.currentSpeed;
    }

    public void setCurrenSpeed(double currenSpeed) {
        this.currentSpeed = currenSpeed;
    }

    public int getCurrentGear() {
        return currentGear;
    }

    public int setCurrentGear(int currentGear) {
        return this.currentGear = currentGear;
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

    protected int gear() {
        for (int i = maxSpeed.size() - 1; i > 0; i--) {
            if (this.currentSpeed == (double) maxSpeed.get(i)) {
                return setCurrentGear(maxSpeed.indexOf(maxSpeed.get(i)));
            } else if (this.currentSpeed > (double) maxSpeed.get(i)) {
                return setCurrentGear(maxSpeed.indexOf(maxSpeed.get(i)));
            }
        }
        // return (int) this.currentSpeed;
        return -1;
    }

    @Override
    public String toString() {
        return "Car [ CurrenSpeed=" + currentSpeed + ", currentGear="
                + gear()
                + ", licensePlate=" + licensePlate + ", maxSpeed=" + maxSpeed + "]";
    }

}
