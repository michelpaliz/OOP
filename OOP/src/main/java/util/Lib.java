package util;

import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;

public class Lib {

    public static Scanner myInput = new Scanner(System.in);

    public static void pausa() {
        System.out.println("Pulsa intro para continuar ....");
        myInput.nextLine();
    }

    public static int random(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    public static void clearScreen() {
        System.out.println("\u000C");
    }


    
    // public static byte[] readFile(String filePath) throws IOException, InputMismatchException {
    //     int fileSize = getFileSize();
    //     byte[] data = new byte[fileSize];
    //     try {
    //         // Abrir archivo
    //         // leerlo

    //     } catch (Exception e) {
    //         // TODO: CERRAR ARCHIVO
    //         throw new IOException(ioe.getMessage()); // la he capturado pero quiero que continue elevandose,
    //     } finally {
    //         // Cerrar archivo
    //     }

    //     return data;

    // }



}
