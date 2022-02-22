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
        System.out.println("***URGENCIAS*****");
        do {
            System.out.println("1-Nuevo Paciente");
            System.out.println("2-Atender Paciente");
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
                System.out.println("INTRODUCE EL NUMERO SIP");
                userInt = Integer.parseInt(myInput.nextLine());

                break;

            case 3:

            case 4:

                break;

        }

    }

    // *CREACION DE PACIENTE (ELECCION 1)
    public Paciente creacionPaciente() {
        System.out.println("INTRODUCE EL NUMERO SIP");
        // +Todo existe o no existe el paciente
    }

    /**
     * 
     * @param sip
     * @return positivo si existe negativo si no existe
     */

    public int buscarPaciente(int sip) {
        for (int i = 0; i < numPaciente; i++) {
            if (pacientes[i].getSip() == sip) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 
     * @param sip
     * @return la posicion del paciente
     */
    public Paciente buscarBicicletaPorNia(int sip) {
        int pos = buscarPaciente(sip);
        return pos < 0 ? null : pacientes[pos];
    }

    // *CREACION DATOS PRUEBA
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

    // *MOSTRACION DE LOS DATOS DE PRUEBA
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
