package Testing.concepts.Polymorphism;

public class Triangle extends Figure {

    private double a;
    private double b;
    private double c;

    public Triangle(double valueA, double valueB, double valueC){
        a = valueA;
        b = valueB;
        c = valueC;

    }

    @Override
    public double calcArea() {
        double p = (a+b+c) / 2;
        double area = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        return area;
    }
    
}
