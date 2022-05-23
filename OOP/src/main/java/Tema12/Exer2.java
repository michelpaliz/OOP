package Tema12;

import java.io.File;
import java.util.Objects;


public class Exer2 {
    public Exer2(String path) {
        File file = new File(path);

        if (file.isDirectory()) {
            String[] files = file.list();
            for (int i = 0; i < Objects.requireNonNull(files).length; i++) {
                System.out.println(files[i]);
            }
        }
    }
}
