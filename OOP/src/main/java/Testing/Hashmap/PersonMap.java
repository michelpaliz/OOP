package Testing.Hashmap;

import java.util.HashMap;

public class PersonMap {

    // Attributes
    private String ID;
    private String name;
    private String lastName;
    private HashMap<Person, Person> personsDB;

    public PersonMap() {
        this.ID = null;
        this.name = null;
        this.lastName = null;
    }

    public PersonMap(String ID, String name, String lastName) {
        this.ID = ID;
        this.name = name;
        this.lastName = lastName;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "PersonMap [ID=" + ID + ", lastName=" + lastName + ", name=" + name + ", personsDB=" + personsDB + "]";
    }

}