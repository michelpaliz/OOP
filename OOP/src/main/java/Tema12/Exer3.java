package Tema12;

import java.io.File;

public class Exer3 {
    public Exer3() {

    }

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println();
            System.exit(-1);
        }
        String file = args[0];
        File f1 = new File(file);
        System.out.println("Folder name");
        System.out.println(f1.getName());
        System.out.println("Absolute path ");
        System.out.println(f1.getAbsolutePath());
        System.out.println("Can it be read ?");
        System.out.println(f1.canRead());
        System.out.println("Can it be written");
        System.out.println(f1.canWrite());
        // Path currentDir = Paths.get(".");
        // System.out.println(currentDir);

    }


}
