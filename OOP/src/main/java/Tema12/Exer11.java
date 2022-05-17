package Tema12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Exer11 {
    public Exer11() {

    }

    public void concatLInes(String f1, String f2) throws FileNotFoundException {
        FileReader fr1 = new FileReader(f1);
        FileReader fr2 = new FileReader(f2);
        try {
            int i;
            while ((i = fr1.read()) != -1)
                // System.out.print((char) i);
            fr1.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
