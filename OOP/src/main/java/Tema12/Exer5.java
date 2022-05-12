package Tema12;

import java.io.File;
import java.io.IOException;

public class Exer5 {

    public Exer5() {

    }

    public boolean createArchive(String directory, String archive) {

        return false;

    }

    public static boolean createFIle(String dir, String file) {

        File f = new File(dir + File.separator + file);
        try {
            if (f.createNewFile()) {
                System.out.println("FIle created");
                return true;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("There was a problem");
        }
        return false;
    }

    public static void listDIrectories(String dir) {
        File f = new File(dir);
        File[] content = f.listFiles();
        if (content != null) {
            for (File file : content) {
                if (file.isDirectory()) {
                    System.out.println(file.getName() + "d");
                    listDIrectories(file.getAbsolutePath());
                } else {
                    System.out.println(file.getName() + "f");
                }
            }
        }

    }

}
