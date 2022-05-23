package Testing.concepts.Polymorphism;

public class MyPolymorphism {
    public MyPolymorphism() {
        Square s = new Square(2);
        System.out.println("Square Area = " + s);
        Triangle t = new Triangle(2, 3, 4);
        System.out.println("Triangle Area = " + t.calcArea());
        System.out.println("Square Area = " + s.calcArea());
    }
}
