package Tema12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
// Importing as it converts bits to strings
import java.io.InputStreamReader;

public class Exer10 {
    public Exer10(String fileName, String path) {
        concat(fileName, path);
    }

    public void concat(String fileName, String path) {

        try {
            // BufferedReader br = new BufferedReader(
            // new InputStreamReader(System.in));
            // System.out.println("Enter the file name:");
            // Reading File name
            // fileName = br.readLine();
            // System.out.println("Enter the file path:");
            // path = br.readLine();
            File file = new File(path + "" + fileName + ".txt");
            file.createNewFile();
            System.out.println(file);
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no se encuentra");
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }

}
