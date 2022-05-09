package Testing.concepts.MyInterface;

public class Bicycle implements Vehicle {

    @Override
    public double gatInsuranceCost(int months) {
        return 25 * months;
    }

}
