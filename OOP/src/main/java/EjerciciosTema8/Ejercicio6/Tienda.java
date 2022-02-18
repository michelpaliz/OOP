package EjerciciosTema8.Ejercicio6;

import java.util.Scanner;

import com.github.javafaker.Faker;

public class Tienda {
    private Scanner myInput = new Scanner(System.in);
    int userInt;
    String userStr;
    int baseDatos;

    public void menu() {
        boolean correct;
        System.out.println("***GESTION DE BICICLETAS*****");
        do {
            System.out.println("1-Añadir bicicleta");
            System.out.println("2-Vender bicicleta");
            System.out.println("3-Mostrar Stock");
            System.out.println("-------------------------");
            System.out.println("0-Salir");
            userInt = Integer.parseInt(myInput.nextLine());
            correct = userInt > 0 && userInt <= 4;

        } while (!correct);

        switch (userInt) {
            case 1:

            case 2:

        }

    }

    public Bicicleta nuevaBicicleta() {
        System.out.println("***VAMOS AÑADIR UNA NUEVA BICICLETA********");
        System.out.println("INSERTA EL NUMERO DE REFERENCIA ");
        String ref = myInput.nextLine();
        System.out.println("INSERTA LA MARCA DE LA BICICLETA");
        String marca = myInput.nextLine();
        System.out.println("INSERTA EL PESO DE LA BICICLETA");
        Double peso = Double.parseDouble(myInput.nextLine());
        System.out.println("INSERTA EL TAMAÑO DE LAS RUEDAS EN PULGADAS");
        Double sizeRuedas = Double.parseDouble(myInput.nextLine());
        System.out.println("TIENE MOTOR (SI/NO)");
        // +Todo metodo para validar esta respuesta
        System.out.println("QUE PRECIO TIENE");
        double precion = Double.parseDouble(myInput.nextLine());
        System.out.println("INDICA EL NUMERO DE EXISTENCIAS QUE TIENEN DE ESA REFERENCIAS");
        /// +Todo metodo para indicar el numero de referencias que hayas
        

    }

    public Tienda() {

        menu();
    }
}
