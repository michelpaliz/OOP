package Tema11.Propios.ejercicio04;

import java.util.Arrays;
import java.util.HashMap;

import com.github.javafaker.Faker;

import Tema11.Propios.ejercicio04.model.Appliance;
import Tema11.Propios.ejercicio04.model.Color;
import Tema11.Propios.ejercicio04.model.Config;
import Tema11.Propios.ejercicio04.model.WashingMachine;
import Util.Lib;

public class App {

    double charge, basePrice;
    Color color;
    char electricalConsum;
    double weight;
    Faker faker = new Faker();
    WashingMachine[] array = new WashingMachine[5];

    public App() {
        fakerData(5);
        for (int i = 0; i < array.length; i++) {
            System.out.println("Final price: " + finalPrice(array[i]));
        }

    }

    public double finalPrice(Appliance a) {
        return a.finalPrice();
    }

    public void fakerData(int size) {

        for (int i = 0; i < size; i++) {
            charge = faker.number().randomDouble(2, 0, 100);
            basePrice = faker.number().randomDouble(2, 50, 100);
            weight = faker.number().randomDouble(2, 20, 200);
            electricalConsum = (char) (Lib.r.nextInt(6) + 'a');
            color = Color.getRandom();
            array[i] = new WashingMachine(charge, color, Character.toUpperCase(electricalConsum), weight, basePrice);
        }
        System.out.println("This is the array");
        System.out.println(Arrays.toString(array));

    }

}
