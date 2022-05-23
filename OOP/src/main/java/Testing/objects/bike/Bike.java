package Testing.objects.bike;

public class Bike {

    private String color;
    private int wheels;
    private double price;
    private double maxSpeed;

    public Bike() {
        this.color = "red";
        this.wheels = 2;
        this.price = 50;
        this.maxSpeed = 100;
    }

    public Bike(String color, int wheels, double price, double maxSpeed) {
        this.color = color;
        this.wheels = wheels;
        this.price = price;
        this.maxSpeed = maxSpeed;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public int getWheels() {
        return wheels;
    }

    public double getSpeed() {
        return maxSpeed;
    }

    public void bikeFeatures() {
        System.out.println("This is a bike ");
    }

    public double setSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString() {
        return "Bike [color=" + color + ", wheels=" + wheels + "]";
    }

}
