package OtrosEjercicios.Campeonato.Collection.base;

public class Person {
    private String id;
    private String name;
    private String lastName;
    private int age;
    private String nacionality;

    public Person(String id, String name, String lastName, int age, String nacionality) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.nacionality = nacionality;
    }
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person [age=" + age + ", id=" + id + ", lastName=" + lastName + ", nacionality=" + nacionality
                + ", name=" + name + "]";
    }



    
}
