package Tema12;

import java.io.FileNotFoundException;
import java.io.IOException;

import OtrosEjercicios.Campeonato.Collection.Game;
import Tema12.Parsers.HIloContador;
import Tema12.TresRaya.ThreeHeads;

public class Main {
    public static void main(String[] args) {
        // Exer1 e1 = new Exer1();
        String path = "/home/michael/Desktop/Tema12";
        String path1 = System.getProperty("user.dir");
        // Exer2 e2 = new Exer2(path);
        // Exer3 e3 = new Exer3();
        // Exer4 e4 = new Exer4();
        // Exer5 e5 = new Exer5();
        // System.out.println(path1);
        // Exer6 e6 = new Exer6(path1);
        // Hex h = new Hex();
        // Exer10 e10 = new Exer10("Name", path);
        // ThreeHeads t = new ThreeHeads();
        // !estoy creando el hilo pero no le indicamos cuando empiezan, asi que
        // !necesitamos el start.
        String[] names = { "MIchael", "Jhoan", "Sanyi", "Bobby" };
        // HIloContador h = new HIloContador(10, "michael");
        HIloContador[] hs = new HIloContador[names.length];
        for (int i = 0; i < names.length; i++) {
            // HIloContador h1 = new HIloContador(10, names[i]);
            hs[i] = new HIloContador(10, names[i]);
            hs[i].start();
            // h1.start();
        }
        // h.start();

        for (int i = 0; i < names.length; i++) {
            try {
                hs[i].join();
                // h.join();
            } catch (InterruptedException ignored) {

            }
        }

        // yo quiero que este mensage salga al final
        System.out.println("Programs ends here");
    }

}
