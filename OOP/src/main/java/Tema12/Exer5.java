package Tema12;

import java.io.File;
import java.io.IOException;

import Lib.Util;

public class Exer5 {

    public Exer5() {
        String path = System.getProperty("user.dir");
        File file1 = new File(path);
        checkFile(file1);
        System.out.println("Introduce the path");
        String user = Util.myInput.nextLine();
        File file2 = new File(user);

        System.out.println("Introduce the file's name");
        if (createArchive(file2.getAbsolutePath(), Util.myInput.nextLine())) {
            System.out.println("FIle created sucessfully");
        } else {
            System.out.println("error");
        }

    }

    // public boolean createArchive(String directory, String archive) {

    // return false;

    // }

    public static String checkRute(String path) {
        File comprobante = new File(path);
        String respuesta;
        if (comprobante.exists()) {
            if (comprobante.isDirectory()) {
                System.out.println("La ruta es correcta");
                return path;
            } else {
                System.out.print(
                        "La ruta es correcta, pero ten encuenta que es un archivo, no podras gestionar nuevas carpetas  deseas cambiar la ruta\nSi/No: ");
                respuesta = Util.myInput.nextLine();
                while (!respuesta.equalsIgnoreCase("Si") && !respuesta.equalsIgnoreCase("No")) {
                    System.out.print("Introduce Si o No\nRespuesta: ");
                    respuesta = Util.myInput.nextLine();
                }
                if (respuesta.equalsIgnoreCase("Si")) {
                    System.out.print("Introduce la nueva ruta\nNueva Ruta: ");
                    return Util.myInput.nextLine();
                } else {
                    return path;
                }
            }
        } else {
            return null;
        }
    }

    public static boolean createArchive(String dir, String archive) {
        for (int i = 0; i < archive.length(); i++) {
            if (archive.charAt(i) == ' ' || archive.charAt(i) == '/' || archive.charAt(i) == '\\') {
                return false;
            }
        }
        File fichero = new File(dir, archive);
        if (fichero.exists()) {
            System.out.println("return true");
            return true;
        }
        try {
            return fichero.createNewFile();
        } catch (IOException ex) {
            System.out.println("return false");
            return false;
        }
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

    /**
     * 
     * @param dir this is recursive
     */

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

    public static char checkFile(File f) {
        if (f.isDirectory()) {
            return 'd';
        } else {
            return 'f';
        }
    }

    public static void showInf(String dir, String archive) {
        File f = new File(dir + File.separator + archive);
        System.out.println("size" + f.length() / Math.pow(1024, 3) + "GB");
    }

    public static String checkOwnership(File f) {
        StringBuilder pms = new StringBuilder();
        if (f.canRead()) {
            pms.insert(pms.length(), "r");
        } else {
            pms.insert(pms.length(), "-");
        }
        if (f.canWrite()) {
            pms.insert(pms.length(), "w");
        } else {
            pms.insert(pms.length(), "-");
        }
        if (f.canExecute()) {
            pms.insert(pms.length(), "x");
        } else {
            pms.insert(pms.length(), "-");
        }
        return pms.toString();
    }

    public static void verInfo(String dir, String archive) {
        File fichero = new File(dir, archive);
        System.out.printf("%-10s" + "%-65s" + "%-5s" + "%-15s" + "%-1s\n", fichero.getName(), fichero.getAbsolutePath(),
                checkOwnership(fichero), fichero.length() + " bytes", checkFile(fichero));
    }

    //add a new method that has to be read and written
}
