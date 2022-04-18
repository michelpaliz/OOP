package Tema11.Propios.ejercicio04;

import java.util.HashMap;

import com.github.javafaker.Faker;

import Tema11.Propios.ejercicio04.model.Appliance;
import Tema11.Propios.ejercicio04.model.Color;
import Tema11.Propios.ejercicio04.model.Config;
import Tema11.Propios.ejercicio04.model.WashingMachine;
import Util.Lib;

public class App {

    public static void finalPrice(Appliance a) {
        a.finalPrice();
    }

    public static void main(String[] args) {

        Faker faker = new Faker();
        WashingMachine[] array = (WashingMachine[]) new Appliance[5];

        double charge, basePrice;
        Color color;
        char electricalConsum;
        double weight;

        // now we create instances for Washingmachines
        for (int i = 0; i < 10; i++) {
            charge = faker.number().randomDouble(2, 0, 100);
            basePrice = faker.number().randomDouble(2, 50, 100);
            weight = faker.number().randomDouble(2, 20, 200);
            electricalConsum = (char) (Lib.r.nextInt(6) + 'a');
            color = Color.getRandom();
            array[i] = new WashingMachine(charge, color, electricalConsum, weight, basePrice);
        }

        Appliance e = new WashingMachine();

    }

}
