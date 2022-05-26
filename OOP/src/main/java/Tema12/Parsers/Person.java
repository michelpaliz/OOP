package Tema12.Parsers;

import Tema11.Propios.ejercicio05.models.objNames;

public class Person {

    // Attributes
    private String name;

    public Person() {
        this.name = null;
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + "]";
    }

}
