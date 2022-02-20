package EjerciciosTema8.Ejercicio6;

//*IMPORT PARA OPERACIONES
import com.github.javafaker.Faker;
import util.Bombo;
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
    String userStr;
    boolean correct; // VALIDACION GENERAL
    public Bicicleta[] bicicletas; // CREACION DE ARRAY PARA LA BASE DE DATOS
    public int numBicicleta; // CONTADOR DE BICICLETAS
    // CREACION DEL STOCK MEDIANTE MATRICES

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

    /**
     * 
     * @param cantidad de datos que quieras introducir
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

    public Tienda(int minBicicletas) {
        bicicletas = new Bicicleta[minBicicletas];
        numBicicleta = 0;
        if (Ejercicio06.DEBUG) {
            crearDatosPrueba(minBicicletas / 2);
        }

    }
}
