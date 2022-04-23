package Testing.Hashmap;

import Util.Control;

import java.util.Arrays;
import java.util.HashMap;

import com.github.javafaker.Faker;

public class Testing {
    private final int INITIALITER = 4;

    public Testing() {
        // public HashMap<String, Integer> empIds = new HashMap<>();

        HashMap<String, Object[][]> inventary = new HashMap<String, Object[][]>();
        HashMap<String, String> personsMap = new HashMap<String, String>();
        // HashMap<Person[],Person[]> personsMap = new HashMap<Person[], Person[]>();

        // capitalCities.put();
        // inventary.put("Hello", );
        // Person person = new Person("53944920", "MIchael", "Paliz");
        Person person;
        // Creating a DB for persons(using array) we use brakets to initialite it to not
        // avoid nullpointerexepction
        Person[] persons = new Person[INITIALITER];

        Faker faker = new Faker();
        String ID, name, lastName;

        // We put values for each person
        for (int i = 0; i < INITIALITER; i++) {
            ID = Control.DNIgeneratorChar(faker.number().digits(8));
            name = faker.name().firstName();
            lastName = faker.name().lastName();
            person = new Person(ID, name, lastName);
            // Now we put values for the DB of persons
            persons[i] = person;
            personsMap.put(person.getID(), person.getName() + " " + person.getLastName());
        }
        // With Arrays
        System.out.println(Arrays.toString(persons));
        // WIth Maps
        System.out.println("This is DB of persons Map");
        System.out.println(personsMap);

        // inventary.put("someKey", new Object[][] {});

    }

}
