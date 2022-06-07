package Testing.concepts.collection;

public class Collection {
    public Collection() {
        CarDealerShip cd = new CarDealerShip();
        Car a1 = new Car("Ford", "FIesta", 1000);
        Car a2 = new Car(" Toyota", "Corilla", 1000);
        cd.cars.add(a1);
        cd.cars.add(a2);
        for (Car car : cd.cars) {
            System.out.println("---------------");
            System.out.println(car);
        }

    }

    public static void sort() {
    }

}
