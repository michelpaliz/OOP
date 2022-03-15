package Tema8.EjemplosTema8.Tema8Adv.ejercicio06;

// import com.germangascon.tema08.utils.Ansi;
// import com.germangascon.tema08.utils.Lib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import Tema8.EjemplosTema8.Tema8Adv.utils.Ansi;
import Tema8.EjemplosTema8.Tema8Adv.utils.Lib;

public class Ejercicio6 {
    private final Scanner lector;
    private final Tienda tienda;

    public Ejercicio6(int maxBicicletas) {
        lector = new Scanner(System.in);
        int opcion;
        tienda = new Tienda(maxBicicletas);
        do {
            opcion = menuPrincipal();
            switch (opcion) {
                case 1:
                    nuevaBicicleta();
                    break;
                case 2:
                    venderBicicleta();
                    break;
                case 3:
                    consultas();
                    break;
                case 4:
                    mostrarStock();
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    break;
            }
        } while(opcion != 0);
    }

    private void venderBicicleta() {
        String referencia;
        int cantidad;
        Bicicleta bicicleta;
        Ansi.clearScreen();
        System.out.println("**************************");
        System.out.println("*** VENTA DE BICICLETA ***" );
        System.out.println("**************************");
        System.out.println("Referencia: ");
        referencia  = lector.nextLine();
        bicicleta = tienda.buscarBicicletaPorReferencia(referencia);
        if(bicicleta != null) {
            System.out.println(bicicleta.toString());
            System.out.println("Unidades a vender: ");
            cantidad = Integer.parseInt(lector.nextLine());
            ResultadoOperacion resultado = tienda.venderBicicleta(referencia, cantidad);
            if (resultado == ResultadoOperacion.UPDATED) {
                System.out.println(cantidad + " unidades de la referencia " + referencia + " vendidas correctamente");
            } else if(resultado == ResultadoOperacion.INSUFFICIENT_STOCK){
                System.out.println("Imposible vender " + cantidad + " unidades. No hay suficiente stock de la referencia " + referencia);
            }
        } else {
            System.out.println("No se ha encontrado la referencia " + referencia);
        }
        Lib.pause();
    }

    private void mostrarStock() {
        int i = 0;
        boolean fin = false;
        Ansi.clearScreen();
        System.out.println(tienda.stockToString());
        Lib.pause();
    }


    private int menuPrincipal() {
        int opcion = -1;
        do {
            Ansi.clearScreen();
            System.out.println("***************************");
            System.out.println("** GESTIÓN DE BICICLETAS **");
            System.out.println("***************************");
            System.out.println("1. Añadir bicicleta...");
            System.out.println("2. Vender bicicleta...");
            System.out.println("3. Consultar bicletas...");
            System.out.println("4. Mostrar stock...");
            System.out.println("---------------------------");
            System.out.println("0. Salir\n");
            System.out.println("Elija una opción: ");
            opcion = Integer.parseInt(lector.nextLine());
            if(opcion < 0 || opcion > 4) {
                System.out.println("Elija una opción del menú [0-4]");
                Lib.pause();
            }
        } while (opcion < 0 || opcion > 4);
        return opcion;
    }

    private int menuConsultas() {
        int opcion = -1;
        do {
            Ansi.clearScreen();
            System.out.println("************************");
            System.out.println("** CONSULTA BICICLETA **");
            System.out.println("************************");
            System.out.println("1. Por referencia...");
            System.out.println("2. Por marca...");
            System.out.println("3. Por modelo...");
            System.out.println("------------------------");
            System.out.println("0. Volver al menú principal\n");
            System.out.println("Elija una opción: ");
            opcion = Integer.parseInt(lector.nextLine());
            if(opcion < 0 || opcion > 3) {
                System.out.println("Elija una opción del menú [0-3]");
                Lib.pause();
            }
        } while (opcion < 0 || opcion > 3);
        return opcion;
    }

    private void consultas() {
        int opcion;
        int i;
        do {
            opcion = menuConsultas();
            switch (opcion) {
                case 1:
                    //Por referencia
                    String referencia;
                    System.out.println("Referencia: ");
                    referencia =lector.nextLine();
                    Bicicleta bicicleta = tienda.buscarBicicletaPorReferencia(referencia);
                    if(bicicleta != null) {
                        System.out.println(bicicleta.toString());
                    } else {
                        System.out.println("No se ha encontrada ninguna bicicleta con la referencia " + referencia);
                    }
                    Lib.pause();
                    break;
                case 2:
                    //Por marca
                    String marca;
                    Bicicleta[] bicicletasMarca;
                    System.out.println("Marca: ");
                    marca = lector.nextLine();
                    bicicletasMarca = tienda.buscarBicicletaPorMarca(marca);
                    if (bicicletasMarca != null) {
                        for (i = 0; i < bicicletasMarca.length; i++) {
                            System.out.println(bicicletasMarca[i].toString());
                        }
                    } else {
                        System.out.println("No se han encontrado bicicletas de la marca " + marca);
                    }
                    Lib.pause();
                    break;
                case 3:
                    //Por modelo
                    String modelo;
                    Bicicleta[] bicicletasModelo;
                    System.out.println("Modelo: ");
                    modelo = lector.nextLine();
                    bicicletasModelo = tienda.buscarBicicletaPorModelo(modelo);
                    if (bicicletasModelo != null) {
                        for (i = 0; i < bicicletasModelo.length; i++) {
                            System.out.println(bicicletasModelo[i].toString());
                        }
                    } else {
                        System.out.println("No se han encontrado bicicletas del modelo " + modelo);
                    }
                    Lib.pause();
                    break;
            }
        } while (opcion != 0);

    }

    private void nuevaBicicleta() {
        String referencia;
        String marca;
        String modelo;
        float peso;
        float tamanyo;
        boolean motor = false;
        GregorianCalendar fechaFabricacion = null;
        float precio;
        int stock;
        boolean validado;

        Ansi.clearScreen();
        System.out.println("*** NUEVA BICICLETA ***" );
        do {
            System.out.println("Referencia: ");
            referencia = lector.nextLine();
            validado = referencia.length() > 2;
            if(!validado) {
                System.out.println("La referencia debe tener un mínimo de 3 caracteres");
                Lib.pause();
            }
        } while (!validado);

        Bicicleta bicicleta = tienda.buscarBicicletaPorReferencia(referencia);
        if(bicicleta != null) {
            System.out.println("La referencia " + referencia + " corresponde a: ");
            System.out.println(bicicleta.toString());
            System.out.println("** AÑADIR UNIDADES **");
            System.out.println("Indique 0 para cancelar");
            System.out.println("Unidades: ");
            int unidades = Integer.parseInt(lector.nextLine());
            validado = unidades >= 0 && unidades < 200;
            if(validado) {
                if(unidades != 0) {
                    ResultadoOperacion resultado = tienda.anyadirStock(referencia, unidades);
                    if(resultado == ResultadoOperacion.UPDATED) {
                        System.out.println(unidades + " unidades añadidas correctamente al stock");
                        System.out.println(bicicleta.toString());
                    } else {
                        System.out.println("No se han podido añadir las unidades indicadas");
                    }
                } else {
                    System.out.println("Cancelado");
                }
            } else {
                System.out.println("El número de unidades debe estar en el rango [0-200]");
            }
            Lib.pause();
            return;
        }

        do {
            System.out.println("Marca: ");
            marca = lector.nextLine();
            validado = marca.length() > 0;
            if(!validado) {
                System.out.println("Debe indicar la marca");
                Lib.pause();
            }
        } while (!validado);

        do {
            System.out.println("Modelo: ");
            modelo = lector.nextLine();
            validado = modelo.length() > 1;
            if(!validado) {
                System.out.println("El modelo debe tener un mínimo de 2 caracteres");
                Lib.pause();
            }
        } while (!validado);

        do {
            System.out.println("Peso: ");
            peso = Float.parseFloat(lector.nextLine());
            validado = peso > 0;
            if(!validado) {
                System.out.println("El peso debe ser mayor que 0");
                Lib.pause();
            }
        } while (!validado);

        do {
            System.out.println("Tamaño: ");
            tamanyo = Float.parseFloat(lector.nextLine());
            validado = tamanyo > 5;
            if(!validado) {
                System.out.println("El tamaño no puede ser inferior a 5");
                Lib.pause();
            }
        } while (!validado);

        do {
            System.out.println("¿Tiene motor? (s/n): ");
            char c = lector.nextLine().toLowerCase().charAt(0);
            if(c == 's') {
                motor = true;
                validado = true;
            } else if (c == 'n') {
                motor = false;
                validado = true;
            } else {
                validado = false;
            }
            if(!validado) {
                System.out.println("Debe responder con 's' ó 'n'");
                Lib.pause();
            }
        } while (!validado);

        do {
            System.out.println("Fecha de fabricación (dd-mm-yyyy): ");
            String fechaFabricacionString = lector.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            try {
                Date date = sdf.parse(fechaFabricacionString);
                fechaFabricacion = new GregorianCalendar();
                fechaFabricacion.setTime(date);
                validado = true;
            } catch (ParseException pe) {
                validado = false;
                System.out.println("El formato de la fecha de fabricación no es válido. Recuerde (dd-mm-yyyy).");
                Lib.pause();
            }
        } while (!validado);

        do {
            System.out.println("Precio: ");
            precio = Float.parseFloat(lector.nextLine());
            validado = precio > 0;
            if(!validado) {
                System.out.println("El precio debe ser mayor que 0");
                Lib.pause();
            }
        } while (!validado);

        do {
            System.out.println("Stock: ");
            stock = Integer.parseInt(lector.nextLine());
            validado = stock >= 0;
            if(!validado) {
                System.out.println("El stock no puede ser negativo");
                Lib.pause();
            }
        } while (!validado);

        ResultadoOperacion resultado = tienda.nuevaBicicleta(referencia, marca, modelo, peso, tamanyo, motor, fechaFabricacion, precio, stock);

        if(resultado == ResultadoOperacion.ADDED) {
            System.out.println("Bicicleta añadida correctamente");
        } else {
            System.out.println("Imposible añadir la bicicleta.");
            System.out.println("Se ha superado la capacidad del almacén");
        }

        Lib.pause();

    }
}
