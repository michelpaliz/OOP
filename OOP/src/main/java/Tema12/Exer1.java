package Tema12;

import java.io.File;

public class Exer1 {
    public Exer1() {

    }

    public static void main(String[] args) {
        File f1 = new File("/home/michael/Desktop/Tema12");
        
        System.out.println("Exists: " + f1.exists());
        System.out.println("Directory: " + f1.isDirectory());
        for (String arg : args) {
            System.out.println(args);
        }
        if (args.length != 1) {
            System.out.println("Use: exer1 ");
            System.exit(-1);
        }
    }

}
