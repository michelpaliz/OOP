package Testing.concepts.Inheritance;

import Testing.objects.car.Vehicle;

public class Inheritance {
    public Inheritance() {
        Vehicle v = new Vehicle("Citronen", "Berlingo");
        System.out.println("--------------------");
        Car a1 = new Car("Ford", "FIesta", 1000);
        Car a2 = new Car(" Toyota", "Corilla", 1000);
        System.out.println(a1);
        System.out.println(a2);

    }
}
