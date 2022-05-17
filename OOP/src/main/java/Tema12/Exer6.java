package Tema12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import Lib.Util;

public class Exer6 {
    public Exer6(String file) {
        readFile(file);

    }

    public static void read(String file) throws FileNotFoundException, IOException {
        String string;
        try (FileReader fr = new FileReader(file)) {
            BufferedReader br = new BufferedReader(fr);
            while ((string = br.readLine()) != null) {
                System.out.println("Starting");
                System.out.println(file);
                System.out.println("Ending");
                // fr.close();
                // br.close();

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }

    public static void readFile(String file) {
        try {
            FileReader leerFichero = new FileReader(file);
            int valor = leerFichero.read();
            while (valor != -1) {
                System.out.print((char) valor);
                valor = leerFichero.read();
            }
            leerFichero.close();
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no se encuentra");
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }

    public static void askReadFile() {
        System.out.print("Introduce la ruta del archivo que quieras leer\nRuta: ");
        try {
            FileReader leerFichero = new FileReader(Util.myInput.nextLine());
            int valor = leerFichero.read();
            while (valor != -1) {
                System.out.print((char) valor);
                valor = leerFichero.read();
            }
            leerFichero.close();
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no se encuentra");
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }

}
