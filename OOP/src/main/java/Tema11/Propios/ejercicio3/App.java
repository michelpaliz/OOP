package Tema11.Propios.ejercicio3;

import java.util.ArrayList;

import Tema11.Propios.ejercicio3.model.Car;
import Util.Ansi;
import Util.Control;
import Util.Conversion;
import Util.Lib;

public class App {
    private final Integer[] SPEEDARRAY = { 30, 60, 100, 140, 195 };
    // private final ArrayList<Integer> SPEED = new ArrayList<Integer>();
    String userStr;
    int option, speed;

    public App() {
        String message = ("Is your car automatic or not? y/n ");
        char[] validate = { 'y' };
        boolean correct = Control.one(message, validate);
        if (correct) {
            System.out.println("Introduce your car's name");
            String licensePlate = userStr = Lib.myInput.nextLine();
            Car car = new Car(licensePlate, Conversion.arrToArrList(SPEEDARRAY));
            do {
                String tittle = "MANUAL CAR FUNCTIONALITIES";
                String sentence[] = { "Exit", "Speed up the car", "Break the car's speed" };
                option = Control.menuGenerator(tittle, sentence);
    
                switch (option) {
                    case 0:
                        System.out.println("See ya");
                        break;
                    case 1:
                        System.out.println("Let's speed up your car, How much would u like to speed it");
                        speed = Integer.parseInt(Lib.myInput.nextLine());
                        car.speedUp(speed);
                        System.out.println(car);
                        break;
                    case 2:
                        System.out.println("Introduce the break amount you'd like to reduce the car's speed");
                        speed = Integer.parseInt(Lib.myInput.nextLine());
                        car.breakSpeed(speed);
                        break;
                }
            } while (option != 0);

        } else {
            String tittle = "AUTOMATIC CAR FUNCTIONALITIES";
            String sentence[] = { "1.Speed up the car", "2.Break the car's speed" };
            Control.menuGenerator(tittle, sentence);
        }

    }

}
