package Testing.concepts.collection;

import java.util.ArrayList;

public class CarDealerShip {

    ArrayList<Car> cars;

    public CarDealerShip() {
        this.cars = new ArrayList<Car>();
    }

    @Override
    public String toString() {
        return "CarDealerShip [cars=" + cars + "]";
    }

}
