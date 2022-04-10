package Tema11.Propios.ejercicio3;

import Tema11.Propios.ejercicio3.model.Car;
import Util.Control;
import Util.Lib;

public class App {
    private final int[] SPEED = { 30, 60, 100, 140, 195 };
    String userStr;
    int option, speed;

    public App () {
        
        
        String message = ("Is your car automatic or not? y/n");
        userStr = Lib.myInput.nextLine();
        char [] validate = {'y'};
       boolean correct =  Control.one(message, validate );
        if (correct) {
            System.out.println("Introduce your car's name");
            String licensePlate =  userStr = Lib.myInput.nextLine();
            Car car = new Car(licensePlate, SPEED);
            String tittle = "MANUAL CAR FUNCTIONALITIES";
            String sentence[] = {"1.Speed up the car","2.Break the car's speed"};
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
                    System.out.println("Introduce the speed you want to stop the car");
                    speed = Integer.parseInt(Lib.myInput.nextLine());
                    car.breakSpeed(speed);
                    break;
            }
            

        } else {
            String tittle = "AUTOMATIC CAR FUNCTIONALITIES";
            String sentence[] = {"1.Speed up the car","2.Break the car's speed"};
            Control.menuGenerator(tittle, sentence);   
        }
        
    }

}
