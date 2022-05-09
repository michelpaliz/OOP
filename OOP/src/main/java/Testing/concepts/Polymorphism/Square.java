package Testing.concepts.Polymorphism;

public class Square extends Figure {
    private double side;

    public Square(double sideValue){
        side = sideValue;
    }
    @Override
    public double calcArea() {
        return side * side;
    }


}
