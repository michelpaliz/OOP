package Tema8.EjerciciosTema8.Ejercicio7;

import java.util.Calendar;
//*IMPORT DATE
import java.util.Date;
import java.util.GregorianCalendar;
import java.time.LocalDate;
import java.time.ZoneId;
//*IMPORT PARA OPERACIONES SECUNDARIAS
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.github.javafaker.Faker;

import Util.*;

public class Registro {
    // *VARIABLES GLOBALES
    // IMPORT SCANNER
    Scanner myInput = new Scanner(System.in);
    // USER RESPUESTA
    int userInt;
    GregorianCalendar edadPaciente = new GregorianCalendar(); // FECHA

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
                creacionPaciente();
                break;
            case 2:
                // atenderPaciente();
                System.out.println(atenderPaciente());
                break;

            case 3:
                mostarStock();

                break;

            case 4:

                break;

        }

    }

    // *CREACION DE PACIENTE (ELECCION 1)
    public Paciente creacionPaciente() {
        Paciente nuevoPaciente = new Paciente();
        System.out.println("INTRODUCE EL NUMERO SIP");
        userInt = Integer.parseInt(myInput.nextLine());

        if (buscarPaciente(userInt) < 0) {
            System.out.println("El paciente no esta registrado");
            int sip = userInt;
            System.out.println("Inserta nombre del paciente");
            String nombre = myInput.nextLine();
            System.out.println("Inserta el genero del paciente");
            Genero genero = genero();
            System.out.println("Inserta la edad del paciente");
            edadPaciente = validarFecha();
            System.out.println("Introduce tu sintomalogia");
            String sintomalogia = myInput.nextLine();
            Date date = new GregorianCalendar().getTime();
            GregorianCalendar fechaEntrada = new GregorianCalendar();
            fechaEntrada.setTime(date);

            nuevoPaciente = new Paciente(sip, nombre, genero, edadPaciente, fechaEntrada, sintomalogia);
            nuevoEspacio(sip, nombre, genero, edadPaciente, fechaEntrada, sintomalogia);

        } else {
            System.out.println("El paciente esta registrado");
            buscarPacientePorSip(userInt);
        }

        // System.out.println(nuevoPaciente);
        menu();
        return nuevoPaciente;

        // +Todo existe o no existe el paciente
    }

    /**
     * 
     * @param sip
     * @param nombre
     * @param genero
     * @param edad
     * @param fechaEntrada
     * @param sintomalogia
     * @return El paciente anyadido en el array pacientes
     */

    public Paciente[] nuevoEspacio(int sip, String nombre, Genero genero, GregorianCalendar edad,
            GregorianCalendar fechaEntrada,
            String sintomalogia) {

        if (buscarPacientePorSip(sip) != null) {
            return null;
        }

        if (numPaciente == pacientes.length) {
            // creamos un nuevo array el doble del viejo
            Paciente[] bicicletasAmpliado = new Paciente[(int) (numPaciente * Ejercicio07.FACTOR_CRECIMIENTO)];
            for (int i = 0; i < pacientes.length; i++) {
                bicicletasAmpliado[i] = pacientes[i];
            }
            pacientes = bicicletasAmpliado;
        }

        Paciente pacienteNuevo = new Paciente(sip, nombre, genero, edad, fechaEntrada, sintomalogia);
        pacientes[numPaciente] = pacienteNuevo;
        numPaciente++;
        menu();
        return pacientes;

    }

    /**
     * 
     * @return fecha de nacimiento
     */
    public GregorianCalendar validarFecha() {
        int anyo;
        int mes;
        int dia;
        GregorianCalendar fechaFabricacion = new GregorianCalendar();
        do {
            System.out.println("INSERTA EL AÑO NACIMIENTO ");
            anyo = Integer.parseInt(myInput.nextLine());
            System.out.println("INSERTA EL MES NACIMIENTO");
            mes = Integer.parseInt(myInput.nextLine());
            System.out.println("INSERTA EL DIA NACIMIENTO");
            dia = Integer.parseInt(myInput.nextLine());
            correct = anyo <= fechaFabricacion.get(Calendar.YEAR) && mes <= 12 && dia <= 31;
            if (!correct) {
                System.out.println("Tu edad no puede ser mayor que la fecha actual");
                System.out.println("La fecha es incorrecta");
            }
        } while (!correct);
        fechaFabricacion = new GregorianCalendar(anyo, mes, dia);
        return fechaFabricacion;

    }

    /**
     * 
     * @return el genero que ul usuario ha escogido
     */
    public Genero genero() {

        Genero genero = Genero.MASCULINO;

        do {
            System.out.println("Escoge tu genero");
            System.out.println("1.Maculino");
            System.out.println("2.Femenino");
            System.out.println("3.Transexual");
            userInt = Integer.parseInt(myInput.nextLine());
            correct = userInt > 0 && userInt < 3;
            if (!correct) {
                System.out.println("Introduce una respuesta correcta");
            }
        } while (!correct);

        switch (userInt) {
            case 1:
                genero = Genero.MASCULINO;
                break;
            case 2:
                genero = Genero.FEMENINO;
                break;
            case 3:
                genero = Genero.TRANSEXUAL;
                break;
        }
        return genero;
    }

    /**
     * 
     * @param sip
     * @return la posicion del paciente
     */
    public Paciente buscarPacientePorSip(int sip) {
        int pos = buscarPaciente(sip);
        return pos < 0 ? null : pacientes[pos];
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

    // *ATENDER PACIENTE (ELECCION 2)
    public Paciente atenderPaciente() {
        Paciente paciente = new Paciente();
        System.out.println("Introduzca el sip del paciente");
        userInt = Integer.parseInt(myInput.nextLine());
        if (buscarPaciente(userInt) < 0) {
            System.out.println(
                    "El paciente no esta todavia registrado tienes que registrarlo primero para poder atenderlo");
        } else {
            System.out.println(
                    "El paciente esta registrado. Ahora vamos a verificar si este paciente ha sido atendido alguna vez");
            paciente = verificarAtencion(buscarPacientePorSip(userInt));

        }
        // System.out.println(paciente);
        return paciente;

    }

    public Paciente verificarAtencion(Paciente paciente) {
        Paciente pacienteAtendido = paciente;
        if (paciente.getPrevRevison() == null) {
            System.out.println("El paciente no ha sido atendido por ningun medico");
            System.out.println("Introduce la pulsacion ");
            int pulsacion = Integer.parseInt(myInput.nextLine());
            System.out.println("Introduce la temperatura");
            int temperatura = Integer.parseInt(myInput.nextLine());
            System.out.println("Introduce la tension sistolica  del paciente");
            int tensionSis = Integer.parseInt(myInput.nextLine());
            System.out.println("Introduce la tension diastolica del paciente");
            int tensionDias = Integer.parseInt(myInput.nextLine());
            PrevRevison revision = new PrevRevison(temperatura, pulsacion, tensionSis, tensionDias);
            PrevRevison revison = paciente.setPrevResion(revision); // !importante;
            pacienteAtendido = new Paciente(paciente);
        } else {
            System.out.println("El paciente ha sido atendido por un medico");
            return pacienteAtendido;
        }
        // System.out.println(pacienteAtendido);
        return pacienteAtendido;

    }

    // *CREACION DATOS PRUEBA
    public void crearDatosPrueba(int cantidad) {
        Bombo bombo = new Bombo(cantidad, 1);
        Faker faker = new Faker();
        for (int i = 0; i < cantidad; i++) {
            int sip = bombo.extraerBola();
            String nombre = faker.name().firstName();
            Genero genero = Genero.getRandom();
            Date edad = faker.date().birthday(18, 40);
            String sintomalogia = faker.animal().name();

            // Inserccion de valores para la fecha de entrada
            // long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
            long minDay = LocalDate.of(2002, 1, 1).toEpochDay();
            long maxDay = LocalDate.of(2015, 12, 31).toEpochDay();
            Config.hora = Lib.random(Config.MIN_HOUR, Config.MAX_HOUR);
            Config.minuto = Lib.random(Config.MIN_MIN, Config.MAX_MIN);
            Config.segundo = Lib.random(Config.MIN_SEGUNDO, Config.MAX_SEGUNDO);

            // Conversion LocalDate to GregorianCalendar
            long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
            LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
            GregorianCalendar fechaEntrada = GregorianCalendar.from(randomDate.atStartOfDay(ZoneId.systemDefault()));
            // setters for time
            fechaEntrada.set(GregorianCalendar.MINUTE, (int) Config.minuto);
            fechaEntrada.set(GregorianCalendar.SECOND, (int) Config.segundo);
            fechaEntrada.set(GregorianCalendar.HOUR, (int) Config.hora);

            // edad
            // GregorianCalendar edadPaciente = new GregorianCalendar();
            edadPaciente.setTime(edad);

            // Estos pacientes ya has estado atendidos asi que generamos valores aleatorios
            Config.temp = Lib.random(Config.MIN_TEMP, Config.MAX_TEMP);
            Config.ppm = Lib.random(Config.MIN_PPM, Config.MAX_PPM);
            Config.tens = Lib.random(Config.MIN_TENS, Config.MAX_TENS);
            Config.temp = Lib.random(Config.MIN_TENS, Config.MAX_TENS);
            // Creacion revision objeto del paciente
            PrevRevison revisonPrevia = new PrevRevison(Config.temp, Config.ppm, Config.tens, Config.temp);
            // Creacion de objeto paciente
            pacientes[i] = new Paciente(sip, nombre, genero, edadPaciente, fechaEntrada, sintomalogia, revisonPrevia);
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

    public void mostarStock() {
        for (int i = 0; i < numPaciente; i++) {
            System.out.println(pacientes[i]);
        }
        Lib.pausa();
        menu();
    }

    public Registro() {
        mostrarStockPrueba(Ejercicio07.MIN_PACIENTES);
        menu();
    }

}
