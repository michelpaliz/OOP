package Tema8.EjerciciosTema8.Ejercicio6;

//*IMPORT PARA OPERACIONES
import com.github.javafaker.Faker;

import Util.Bombo;
import Util.Lib;

//*IMPORT DATE PACKAGES
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Tienda {
    // SCANNER
    Scanner myInput = new Scanner(System.in);
    // USER RESPUESTA
    int userInt;
    // String userStr;
    boolean correct; // VALIDACION GENERAL
    GregorianCalendar fechaFabricacion; // Fecha general para uso
    public Bicicleta[] bicicletas; // CREACION DE ARRAY PARA LA BASE DE DATOS
    public int numBicicleta; // CONTADOR DE BICICLETAS

    // *MENU PRINCIPAL
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
                break;
            case 1:
                nuevaBicicleta();
                break;
            case 2:
                System.out.println("INTRODUCE EL NUMERO DE REFERENCIA");
                userInt = Integer.parseInt(myInput.nextLine());
                eliminarBicicleta(userInt);
                break;

            case 3:

            case 4:
                mostarStock();
                break;

        }

    }

    // *CREACION NUEVA BICICLETA (OPCION NUMERO 1)
    /**
     * 
     * @return clase Bicicleta
     */

    public void nuevaBicicleta() {
        System.out.println("***VAMOS AÑADIR UNA NUEVA BICICLETA********");
        System.out.println("INSERTA EL NUEVO NUMERO DE REFERENCIA ");
        int ref = Integer.parseInt(myInput.nextLine());
        System.out.println("INSERTA LA MARCA DE LA BICICLETA");
        Marca marca = chooseMarca();
        System.out.println("INSERTA EL MODELO DE LA BICICLETA");
        Modelo modelo = chooseModelo();
        System.out.println("INSERTA EL PESO DE LA BICICLETA");
        Double peso = Double.parseDouble(myInput.nextLine());
        System.out.println("INSERTA EL TAMAÑO DE LAS RUEDAS EN PULGADAS");
        Double sizeRuedas = Double.parseDouble(myInput.nextLine());
        System.out.println("TIENE MOTOR (SI/NO)");
        String motor = myInput.nextLine();
        validarMotor(motor);
        System.out.println("INDICA LA FECHA DE FABRICACION");
        fechaFabricacion = validarFecha();
        System.out.println("INDICA EL PRECIO DE LA BICICLETA");
        double precio = Double.parseDouble(myInput.nextLine());
        System.out.println("INDICA EL NUMERO DE EXISTENCIAS QUE TIENEN DE ESA REFERENCIAS");
        // +Todo metodo para indicar el numero de referencias que hay
        int existencias = Integer.parseInt(myInput.nextLine());
        nuevoEspacio(ref, marca, modelo, peso, sizeRuedas, motor, fechaFabricacion, precio, existencias);

    }

    public Bicicleta[] nuevoEspacio(int referencia, Marca marca, Modelo modelo, double peso, double dimensionRuedas,
            String motor,
            GregorianCalendar fechaFabricacion, double precio, int numeroExistencias) {

        if (buscarBicicletaPorNia(referencia) != null) {
            return null;
        }
        if (numBicicleta == bicicletas.length) {
            // creamos un nuevo array el doble del viejo
            Bicicleta[] bicicletasAmpliado = new Bicicleta[(int) (numBicicleta * Ejercicio06.FACTOR_CRECIMIENTO)];
            for (int i = 0; i < bicicletas.length; i++) {
                bicicletasAmpliado[i] = bicicletas[i];
            }
            bicicletas = bicicletasAmpliado;
        }

        Bicicleta bicicletaNueva = new Bicicleta(referencia, marca, modelo, peso, dimensionRuedas, motor,
                fechaFabricacion, precio,
                numeroExistencias);
        bicicletas[numBicicleta] = bicicletaNueva;
        numBicicleta++;
        menu();
        return bicicletas;
    }

    /**
     * 
     * @return escoge un modelo de la clase enum
     */
    public Marca chooseMarca() {
        Marca respuesta = Marca.CERVELO;
        do {
            System.out.println("*ESCOGE UNA OPCION PARA EL MODELO*");
            System.out.println("1.SPECIALIZED");
            System.out.println("2.TRECK");
            System.out.println("3.SCOTT");
            System.out.println("4.CERVELO");
            System.out.println("5.SANTA");
            userInt = Integer.parseInt(myInput.nextLine());
            correct = userInt > 0 && userInt <= 5;
            if (!correct) {
                System.out.println("Escoge una opcion valida");
            }
        } while (!correct);

        switch (userInt) {
            case 1:
                respuesta = Marca.SPECIALIZED;
                break;
            case 2:
                respuesta = Marca.TRECK;
                break;
            case 3:
                respuesta = Marca.SCOTT;
                break;
            case 4:
                respuesta = Marca.SANTA;
                break;
        }
        return respuesta;

    }

    /**
     * 
     * @return el modelo de eleccion del usuario
     */
    public Modelo chooseModelo() {
        Modelo respuesta = Modelo.CARRETERA;
        do {
            System.out.println("*ESCOGE UNA OPCION DEL MODELO*");
            System.out.println("1.CARRETERA");
            System.out.println("2.MONTANYA");
            System.out.println("3.COMPETICION");
            userInt = Integer.parseInt(myInput.nextLine());
            correct = userInt > 0 && userInt <= 3;
            if (!correct) {
                System.out.println("Escoge una opcion valida");
            }
        } while (!correct);
        switch (userInt) {
            case 1:
                respuesta = Modelo.CARRETERA;
                break;
            case 2:
                respuesta = Modelo.MONTANYA;
                break;
            case 3:
                respuesta = Modelo.COMPETICION;
                break;

        }
        return respuesta;

    }

    /**
     * 
     * @return fecha del usuario
     */

    public GregorianCalendar validarFecha() {
        int anyo;
        int mes;
        int dia;
        GregorianCalendar fechaFabricacion = new GregorianCalendar();
        do {
            System.out.println("INSERTA EL AÑO ");
            anyo = Integer.parseInt(myInput.nextLine());
            System.out.println("INSERTA EL MES");
            mes = Integer.parseInt(myInput.nextLine());
            System.out.println("INSERTA EL DIA");
            dia = Integer.parseInt(myInput.nextLine());
            correct = anyo <= fechaFabricacion.get(Calendar.YEAR) && mes <= 12 && dia <= 31;
            if (!correct) {
                System.out.println("La fecha de fabricacion no puede ser superior a la actual");
                System.out.println("La fecha es incorrecta");
            }
        } while (!correct);
        fechaFabricacion = new GregorianCalendar(anyo, mes, dia);
        return fechaFabricacion;

    }

    // *ELIMINAR BICICLETEA (OPCION NUMERO 2)

    /**
     * 
     * @param ref
     * @return un numero positivo o si es negativo que significa que el indice de la
     *         referencia no existe en el array
     */
    public int buscarBicleta(int ref) {
        for (int i = 0; i < numBicicleta; i++) {
            if (bicicletas[i].getReferencia() == ref) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 
     * @param ref
     * @return la posicion o indice de la refencia introducida anteriormente
     */

    public Bicicleta buscarBicicletaPorNia(int ref) {
        int pos = buscarBicleta(ref);
        return pos < 0 ? null : bicicletas[pos];
    }

    public boolean eliminarBicicleta(int ref) {
        int pos = buscarBicleta(ref);
        if (pos < 0) {
            return false;
        }
        bicicletas[pos] = bicicletas[numBicicleta - 1];
        bicicletas[numBicicleta - 1] = null;
        numBicicleta--;
        Lib.pausa();
        menu();
        return true;

    }

    // *CREACION DE DATOS RANDOM
    /**
     * 
     * @param cantidad que deseamos generar de stock
     */

    public void crearDatosPrueba(int cantidad) {
        Date fechaMin = new GregorianCalendar(2000, Calendar.JANUARY, 1).getTime();
        Date fechaMax = new GregorianCalendar().getTime();
        Bombo bombo = new Bombo(cantidad, 1);
        Faker faker = new Faker();
        for (int i = 0; i < cantidad; i++) {
            int ref = bombo.extraerBola();
            Marca marca = Marca.getRandom();
            Modelo modelo = Modelo.getRandom();
            double peso = faker.number().randomDouble(2, 1, 100);
            double dimensionRuedas = faker.number().randomDouble(2, 1, 100);
            String motor = siOno(faker.random().nextBoolean());
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

    /**
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

    /**
     * 
     * @param randomValue (De faker (true/false)
     * @return si o no
     */

    public String siOno(boolean randomValue) {
        String answer = "";
        if (randomValue == true) {
            answer = "si";
        } else {
            answer = "no";
        }
        return answer;
    }

    // *MOSTRACION DEL STOCK
    /**
     * 
     * @param minBicicletas de datos que quieras introducir para mostar datos
     *                      aleatorios
     */
    public void mostrarStockPrueba(int minBicicletas) {
        System.out.println("GENERACION DE STOCK RANDOM");
        bicicletas = new Bicicleta[minBicicletas];
        numBicicleta = 0;
        if (Ejercicio06.DEBUG) {
            crearDatosPrueba(minBicicletas / 2);
        }
    }

    /**
     * muestra el stock actual
     */

    public void mostarStock() {
        for (int i = 0; i < numBicicleta; i++) {
            System.out.println(bicicletas[i]);
        }
        Lib.pausa();
        menu();
    }
    // *TIENDA

    public Tienda() {
        mostrarStockPrueba(Ejercicio06.MIN_BICLETAS);
        menu();

    }
}
