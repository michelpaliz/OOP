package EjerciciosTema8.Ejercicio7;

//*IMPORT DATE
import java.util.Date;
import java.util.GregorianCalendar;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
//*IMPORT PARA OPERACIONES PRIMARIAS
import util.*;
//*IMPORT PARA OPERACIONES SECUNDARIAS
import java.util.Scanner;
import com.github.javafaker.Faker;

public class Registro {
    // *IMPORT SCANNER
    Scanner myInput = new Scanner(System.in);
    // *USER RESPUESTA
    int userInt;
    // *VARIABLES GLOBALES
    boolean correct;
    private Paciente pacientes[];
    int numPaciente;

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
        for (int i = 0; i < cantidad; i++) {
            int sip = bombo.extraerBola();
            String nombre = faker.name().firstName();
            Genero genero = Genero.getRandom();
            Date edad = faker.date().birthday(18, 40);
            Date fecha = faker.date().between(fechaMin, fechaMax);
            String sintomalogia = faker.animal().name();

            GregorianCalendar fechaAlta = new GregorianCalendar();
            fechaAlta.setTime(fecha);
            GregorianCalendar edadPaciente = new GregorianCalendar();
            edadPaciente.setTime(edad);

            pacientes[i] = new Paciente(sip, nombre, genero, edadPaciente, fechaAlta, sintomalogia);
            System.out.println(pacientes[i]);
            numPaciente++;
        }
    }

    // /**
    // *
    // * @param edad convertir la fecha de naciemento a edad
    // * @return edad del paciente segun su fecha de nacimiento
    // */
    // public int getEdad2(GregorianCalendar edad) {
    // LocalDate fechaActual = LocalDate.now();
    // int anyoNacimiento = edad.get(Calendar.YEAR);
    // int mesNacimiento = edad.get(Calendar.MONTH) + 1; //
    // int diaNacimiento = edad.get(Calendar.DAY_OF_MONTH);
    // LocalDate fechaNacimiento = LocalDate.of(diaNacimiento, mesNacimiento,
    // anyoNacimiento);
    // Period periodo = Period.between(fechaActual, fechaNacimiento);
    // return periodo.getYears();
    // }

    // *MOSTRACION DEL STOCK
    /**
     * 
     * @param minBicicletas de datos que quieras introducir para mostar datos
     *                      aleatorios
     */
    public void mostrarStockPrueba(int minPacientes) {
        System.out.println("GENERACION DE STOCK RANDOM");
        pacientes = new Paciente[minPacientes];
        numPaciente = 0;
        if (Ejercicio07.DEBUG) {
            crearDatosPrueba(minPacientes / 2);
        }
    }

    public Registro() {
        mostrarStockPrueba(Ejercicio07.MIN_PACIENTES);
    }

}
