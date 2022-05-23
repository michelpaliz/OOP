package Testing.concepts.collection;

import Testing.objects.car.Vehicle;

public class Car extends Vehicle {
    private int horsePower;

    public Car(String brand, String model, int horsePowerValue) {
        super(brand, model);
        horsePower = horsePowerValue;
    }

    @Override
    public String toString() {
        return super.toString() + " Car [horsePower=" + horsePower + "]";
    }

}
