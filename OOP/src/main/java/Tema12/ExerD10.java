package Tema12;

import java.io.*;

public class ExerD10 {
    public ExerD10() {
        String directorio = Config.RUTA_DIRECTORIO;
        String nArchivoUno = "nuevoArchivo.txt";
        String nArchivoDos = "nuevoArchivo2.txt";

        File archivoUno = new File(directorio, nArchivoUno);
        File archivoDos = new File(directorio, nArchivoDos);

        try {
            if (concat(archivoUno, archivoDos)) {
                System.out.println("Los archivos se han unido correctamente");
            } else {
                System.out.println("No se han podido unir los dos archivos");
            }
        } catch (IOException ioe) {

        }
    }

    private boolean concat(File archivoUno, File archivoDos) throws IOException {
        if (!archivoUno.isFile() || !archivoDos.isFile()) {
            return false;
        }

        String cadena;
        File archivoFinal = new File(archivoUno.getParent(), "archivoFinalEj10.txt");
        FileReader fr = new FileReader(archivoUno);
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter(archivoFinal);
        BufferedWriter bw = new BufferedWriter(fw);

        while ((cadena = br.readLine()) != null) {
            bw.write(cadena);
            bw.newLine();
            bw.flush();
        }
        fr.close();
        br.close();

        fr = new FileReader(archivoDos);
        br = new BufferedReader(fr);

        while ((cadena = br.readLine()) != null) {
            bw.write(cadena);
            bw.newLine();
            bw.flush();
        }
        fr.close();
        br.close();
        fw.close();
        bw.close();

        return true;
    }
}