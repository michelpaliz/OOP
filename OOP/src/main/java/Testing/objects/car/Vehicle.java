package Testing.objects.car;

public class Vehicle {
    String brand;
    String model;

    public Vehicle(String brand, String model){
        this.brand = brand;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Vehicle [brand=" + brand + ", model=" + model + "]";
    }

    

}
