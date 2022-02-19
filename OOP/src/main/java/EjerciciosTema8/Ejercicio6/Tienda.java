package EjerciciosTema8.Ejercicio6;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import util.Bombo;
import java.time.LocalDate;

import com.github.javafaker.Faker;

public class Tienda {
    int userInt;
    String userStr;
    int baseDatos;
    boolean correct;
    Scanner myInput = new Scanner(System.in);

    public void menu() {
        System.out.println("***GESTION DE BICICLETAS*****");
        do {
            System.out.println("1-Añadir bicicleta");
            System.out.println("2-Vender bicicleta");
            System.out.println("3-Consultar bicileta");
            System.out.println("4.Mostrar Stock");
            System.out.println("-------------------------");
            System.out.println("0-Salir");
            userInt = Integer.parseInt(myInput.nextLine());
            correct = userInt <= 4;
            if (!correct) {
                System.out.println("Introduce un numero valido");
            }

        } while (!correct);

        switch (userInt) {
            case 0:
                System.out.println("Hasta luego");
            case 1:
                nuevaBicicleta();
            case 2:

            case 3:

            case 4:

        }

    }

    /**
     * 
     * @return clase Bicicleta
     */

    public void nuevaBicicleta() {
        System.out.println("***VAMOS AÑADIR UNA NUEVA BICICLETA********");
        System.out.println("INSERTA EL NUMERO DE REFERENCIA ");
        int ref = Integer.parseInt(myInput.nextLine());
        System.out.println("INSERTA LA MARCA DE LA BICICLETA");
        String marca = myInput.nextLine();
        System.out.println("INSERTA EL PESO DE LA BICICLETA");
        Double peso = Double.parseDouble(myInput.nextLine());
        System.out.println("INSERTA EL TAMAÑO DE LAS RUEDAS EN PULGADAS");
        Double sizeRuedas = Double.parseDouble(myInput.nextLine());
        System.out.println("TIENE MOTOR (SI/NO)");
        String motor = myInput.nextLine();
        validarMotor(motor);
        System.out.println("QUE PRECIO TIENE");
        double precion = Double.parseDouble(myInput.nextLine());
        System.out.println("INDICA LA FECHA DE FABRICACION");
        validarFecha();
        System.out.println("INDICA EL NUMERO DE EXISTENCIAS QUE TIENEN DE ESA REFERENCIAS");
        // +Todo metodo para indicar el numero de referencias que hay
    }

    /**
     * 
     * @return fecha del usuario
     */
    public String validarFecha() {
        int anyo;
        int mes;
        int dia;
        String fechaStr = "";
        GregorianCalendar fecha = new GregorianCalendar();
        do {
            System.out.println("INSERTA EL AÑO ");
            anyo = Integer.parseInt(myInput.nextLine());
            System.out.println("INSERTA EL MES");
            mes = Integer.parseInt(myInput.nextLine());
            System.out.println("INSERTA EL DIA");
            dia = Integer.parseInt(myInput.nextLine());
            correct = anyo <= fecha.get(Calendar.YEAR) && mes > 12 && dia > 31;
            if (!correct) {
                System.out.println("La fecha de fabricacion no puede ser superior a la actual");
                System.out.println("La fecha es incorrecta");
            }
        } while (!correct);
        fechaStr = dia + "/" + mes + "/" + anyo;
        return fechaStr;

    }

    /**
     * SS
     * 
     * @param motor
     * @return una respuesta valida como si o no
     */

    public String validarMotor(String motor) {

        String respuesta = "";
        if (motor.equalsIgnoreCase("si") || motor.equalsIgnoreCase("no")) {
            correct = true;
        } else {
            correct = false;
        }
        if (correct == true) {
            respuesta = motor;
        }
        return respuesta;

    }

    public Tienda() {
        Faker faker = new Faker();
        Bicicleta bicleta1 = new Bicicleta("h21", "Giant Bycle", 20, 20, validarMotor("si"), ASDF, 2000, 2);
        System.out.println(validarFecha());

    }
}
