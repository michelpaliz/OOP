package EjerciciosTema8.Ejercicio7;

//*IMPORT DATE
import java.util.GregorianCalendar;
import java.util.Calendar;
//*IMPORT PARA OPERACIONES
import java.util.Scanner;
import util.*;

public class Registro {
    // *IMPORT SCANNER
    Scanner myInput = new Scanner(System.in);
    // *USER RESPUESTA
    int userInt;
    boolean correct;

    // *MENU PRINCIPAL
    public void menu() {
        System.out.println("***GESTION DE BICICLETAS*****");
        do {
            System.out.println("1-Nuevo Paciente");
            System.out.println("2-Atendier Paciente");
            System.out.println("3-Consultas");
            System.out.println("4.Alta Medica");
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
                break;
            case 1:

                break;
            case 2:
                System.out.println("INTRODUCE EL NUMERO DE REFERENCIA");
                userInt = Integer.parseInt(myInput.nextLine());

                break;

            case 3:

            case 4:

                break;

        }

    }

    public void crearDatosPrueba(int cantidad) {
        Date fechaMin = new GregorianCalendar(2000, Calendar.JANUARY, 1).getTime();
        Date fechaMax = new GregorianCalendar().getTime();
        Bombo bombo = new Bombo(cantidad, 1);
        Faker faker = new Faker();
        for (int i = 0; i  cantidad; i++) {
            int sip = bom .extraerBola();
            Genero genero = Genero.getRandom();
            Date fecha = faker.date().between(fechaMin, fechaMax);
            double precio = faker.number().randomDouble(2, 20, 5000);
            int numeroExistencias = faker.number().randomDigitNotZero();

            GregorianCalendar fechaFabricacion = new GregorianCalendar();
            fechaFabricacion.setTime(fecha);
            bicicletas[i] = new Bicicleta(ref, marca, modelo, peso, dimensionRuedas, motor, fechaFabricacion, precio,
                    numeroExistencias);
            System.out.println(bicicletas[i]);
            numBicicleta++;
        }
    }

    public Registro() {

    }

}
