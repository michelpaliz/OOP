package Tema11.Propios.ejercicio03;

import java.util.ArrayList;

import Lib.Ansi;
import Lib.Control;
import Lib.Conversion;
import Lib.Util;
import Tema11.Propios.ejercicio03.model.Atomatic;
import Tema11.Propios.ejercicio03.model.Car;

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
            String licensePlate = userStr = Util.myInput.nextLine();
            // Car car = new Car(licensePlate, Conversion.arrToArrList(SPEEDARRAY));
            //Clase 
            // Atomatic car1 = new Atomatic(licensePlate,Conversion.arrToArrList(SPEEDARRAY));
            ArrayList<Car> car = new ArrayList<>();
            car.add(new Atomatic(licensePlate, Conversion.arrToArrList(SPEEDARRAY)));
            
            for (Car carFound : car) {
                    carFound.speedUp(30);
            }

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
                        speed = Integer.parseInt(Util.myInput.nextLine());
                        car.speedUp(speed);
                        System.out.println(car);
                        break;
                    case 2:
                        System.out.println("Introduce the break amount you'd like to reduce the car's speed");
                        speed = Integer.parseInt(Util.myInput.nextLine());
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
