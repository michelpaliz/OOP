package Tema12;

import java.io.File;

public class Exer1 {
    public Exer1() {
        File f1 = new File("/home/michael/Desktop/Tema12");
        System.out.println("Exists: " + f1.exists());
        System.out.println("Directory: " + f1.isDirectory());
    }
}
