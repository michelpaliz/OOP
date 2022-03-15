package com.germangascon.tema08.ejercicio07;

import com.germangascon.tema08.utils.Ansi;
import com.germangascon.tema08.utils.Lib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ejercicio7 {
    public static final int MAX_PACIENTES = 500;
    public static final int MAX_REGISTROS_HISTORICO = 2000;
    private final Scanner lector;
    private final CentroSalud centro;

    public Ejercicio7() {
        lector = new Scanner(System.in);
        int opcion;
        centro = new CentroSalud(MAX_PACIENTES, MAX_REGISTROS_HISTORICO);
        centro.generarDatosAleatorios(80, 100);
        do {
            opcion = menuPrincipal();
            switch (opcion) {
                case 1:
                    nuevoPaciente();
                    break;
                case 2:
                    atenderPaciente();
                    break;
                case 3:
                    consultas();
                    break;
                case 4:
                    altaMedica();
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    break;
            }
        } while (opcion != 0);

        lector.close();
    }

    private void altaMedica() {
        int sip;
        int i = 1;
        boolean validado;
        int opcion;
        AtencionMedica atencionPaciente;
        System.out.println("Sip: ");
        sip = Integer.parseInt(lector.nextLine());
        atencionPaciente = centro.obtenerRegistroAtencionPaciente(sip);
        if(atencionPaciente != null) {
            do {
                System.out.println("*****************");
                System.out.println("** MOTIVO ALTA **");
                System.out.println("*****************");
                for (AtencionMedica.MotivoAlta motivoAlta : AtencionMedica.MotivoAlta.values()) {
                    System.out.println(i + ". " + motivoAlta);
                    i++;
                }
                System.out.print("\nElija un motivo: ");
                opcion = Integer.parseInt(lector.nextLine());
                validado = opcion >= 1 && opcion <= AtencionMedica.MotivoAlta.values().length;
                if(!validado) {
                    System.out.println("Elija una opción del menú");
                }
            } while (!validado);
            if(atencionPaciente.darAlta(AtencionMedica.MotivoAlta.fromInteger(opcion-1))) {
                System.out.println("El paciente ha sido de alta correctamente");
            } else {
                System.out.println("No se ha podido dar de alta al paciente");
            }
        } else {
            System.out.println("No se ha encontrado el paciente con sip " + sip);
        }
    }

    private void atenderPaciente() {
        int sip;
        int i = 0;
        boolean validado;
        AtencionMedica atencionPaciente;
        System.out.println("Sip: ");
        sip = Integer.parseInt(lector.nextLine());
        atencionPaciente = centro.obtenerRegistroAtencionPaciente(sip);
        if(atencionPaciente != null) {
            float temperatura;
            float ppm;
            float tenSis;
            float tenDias;
            do {
                System.out.println("Temperatura: ");
                temperatura = Float.parseFloat(lector.nextLine());
                validado = temperatura >= 33 && temperatura <= 45;
                if(!validado) {
                    System.out.println("Comprueba el rango de temperaturas [33-45]: ");
                }
            } while(!validado);
            do {
                System.out.println("Pulsaciones por minuto: ");
                ppm = Float.parseFloat(lector.nextLine());
                validado = ppm >= 35 && temperatura <= 220;
                if(!validado) {
                    System.out.println("Comprueba el rango de ppm [35-220]: ");
                }
            } while(!validado);
            do {
                System.out.println("Tensión sistólica: ");
                tenSis = Float.parseFloat(lector.nextLine());
                validado = ppm >= 50 && temperatura <= 250;
                if(!validado) {
                    System.out.println("Comprueba el rango de la tensión sistólica [50-250]: ");
                }
            } while(!validado);
            do {
                System.out.println("Tensión diastólica: ");
                tenDias = Float.parseFloat(lector.nextLine());
                validado = ppm >= 20 && temperatura <= 150;
                if(!validado) {
                    System.out.println("Comprueba el rango de la tensión sistólica [20-150]: ");
                }
            } while(!validado);
            if(centro.atenderPaciente(sip, temperatura, ppm, tenSis, tenDias)) {
                System.out.println("Paciente atendido correctamente");
            } else {
                System.out.println("El paciente no ha podido ser atendido");
            }
        } else {
            System.out.println("El paciente con sip " + sip + " no está registrado en el sistema");
        }
    }

    private void nuevoPaciente() {
        boolean validado;
        int sip;
        int pos;
        String sintomatologia;
        GregorianCalendar fechaEntrada;

        Ansi.clearScreen();
        System.out.println("**********************");
        System.out.println("*** NUEVO PACIENTE ***" );
        System.out.println("**********************");
        do {
            System.out.println("Sip: ");
            sip = Integer.parseInt(lector.nextLine());
            //Aquí iría la validación
            validado = sip > 100;
            if(!validado) {
                System.out.println("El sip debe ser un número mayor que 100");
                Lib.pause();
            }
        } while (!validado);

        pos = centro.buscarPacientePorSip(sip);
        if (pos < 0) {
            do {
                System.out.println("No existe ningún paciente registrado con el sip " + sip);
                System.out.println("¿Desea registrarlo ahora?(s/n): ");
                char r = lector.nextLine().toLowerCase().charAt(0);
                if (r == 's') {
                    String nombre;
                    String apellido1;
                    String apellido2;
                    Paciente.Sexo sexo = null;
                    int edad;
                    validado = true;
                    do {
                        System.out.println("Nombre: ");
                        nombre = lector.nextLine();
                        validado = nombre.length() >= 2;
                        if(!validado) {
                            System.out.println("Nombre debe tener almenos 2 caracteres");
                        }
                    } while (!validado);
                    do {
                        System.out.println("Apellido1: ");
                        apellido1 = lector.nextLine();
                        validado = apellido1.length() >= 2;
                        if(!validado) {
                            System.out.println("Apellido1 debe tener almenos 2 caracteres");
                        }
                    } while (!validado);
                    do {
                        System.out.println("Apellido2: ");
                        apellido2 = lector.nextLine();
                        validado = apellido2.length() >= 2;
                        if(!validado) {
                            System.out.println("Apellido2 debe tener almenos 2 caracteres");
                        }
                    } while (!validado);
                    do {
                        System.out.println("Sexo ([V-M]: ");
                        char s = lector.nextLine().toLowerCase().charAt(0);
                        if(s == 'v') {
                            sexo = Paciente.Sexo.V;
                            validado = true;
                        } else if (s == 'm') {
                            sexo = Paciente.Sexo.M;
                            validado = true;
                        } else {
                            validado = false;
                            System.out.println("Debe indicar 'V' ó 'M'");
                        }
                    } while (!validado);
                    do {
                        System.out.println("Edad: ");
                        edad = Integer.parseInt(lector.nextLine());

                        validado = edad >= 0;
                        if(!validado) {
                            System.out.println("La edad no puede ser negativa");
                        }
                    } while (!validado);
                    pos = centro.nuevoPaciente(sip, nombre, apellido1, apellido2, sexo, edad);
                    if(pos >= 0) {
                        System.out.println("Se ha creado el paciente: ");
                    }
                } else if (r == 'n') {
                    return;
                } else {
                    System.out.println("Debe responder 's' ó 'n'");
                    validado = false;
                }
            } while (!validado);
        }
        //Mostramos el paciente
        System.out.println(centro.getPacientes()[pos].toString());
        do {
            System.out.println("Indique los síntomas del paciente: ");
            sintomatologia = lector.nextLine();
            validado = sintomatologia.length() > 5;
            if (!validado) {
                System.out.println("Por favor, explique mejor los síntomas del paciente");
            }
        } while(!validado);

        if(centro.registrarPaciente(centro.getPacientes()[pos], sintomatologia) >= 0) {
            System.out.println("Paciente registrado correctamente");
            System.out.println("El paciente debe esperar en la sala de espera");
        } else {
            System.out.println("Se ha producido un error al registrar el paciente");
        }
    }

    private int menuPrincipal() {
        int opcion = -1;
        do {
            Ansi.clearScreen();
            System.out.println("*********************");
            System.out.println("**    URGENCIAS    **");
            System.out.println("*********************");
            System.out.println("1. Nuevo paciente...");
            System.out.println("2. Atender paciente...");
            System.out.println("3. Consultas...");
            System.out.println("4. Alta médica...");
            System.out.println("---------------------");
            System.out.println("0. Salir\n");
            System.out.println("Elija una opción: ");
            opcion = Integer.parseInt(lector.nextLine());
            if (opcion < 0 || opcion > 4) {
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
            System.out.println("*********************");
            System.out.println("**    CONSULTAS    **");
            System.out.println("*********************");
            System.out.println("1. Por Sip...");
            System.out.println("2. Por fechas...");
            System.out.println("3. Estadísticas...");
            System.out.println("4. Histórico mensual...");
            System.out.println("------------------------");
            System.out.println("0. Volver al menú principal\n");
            System.out.println("Elija una opción: ");
            opcion = Integer.parseInt(lector.nextLine());
            if(opcion < 0 || opcion > 4) {
                System.out.println("Elija una opción del menú [0-4]");
                Lib.pause();
            }
        } while (opcion < 0 || opcion > 4);
        return opcion;
    }

    private void consultas() {
        int opcion;
        int i;
        boolean validado = false;
        do {
            opcion = menuConsultas();
            switch (opcion) {
                case 1:
                    //Por sip
                    consultaPorSip();
                    break;
                case 2:
                    //Por fechas
                    consultaPorFechas();
                    break;
                case 3:
                    //Estadísticas
                    mostrarEstadisticas();
                    break;
                case 4:
                    //Mostrar histórico
                    mostrarHistorico();
                    break;
            }
        } while (opcion != 0);
    }

    private void mostrarHistorico() {
        int i;
        i = 0;
        boolean fin = false;
        AtencionMedica[] historial = centro.getHistorial();
        while(i < historial.length && !fin) {
            if(historial[i]!= null) {
                System.out.println(historial[i].toString());
                i++;
            } else {
                fin = true;
            }
        }
        Lib.pause();
    }

    private void mostrarEstadisticas() {
        //Podríamos haber implementado un método que calculara todas las medias con una sola pasada de bucle
        //pero cada uno por separado queda más claro
        float[] preRev = centro.mediaPreRev();
        System.out.printf("Media temperatura: %.2f\n", preRev[0]);
        //También podríamos hacerlo mediante:
        //System.out.printf("Media temperatura: %.2f\n", centro.mediaTemperatura());
        System.out.printf("Media ppm: %.0f\n", preRev[1]);
        //System.out.printf("Media ppm: %.0f\n", centro.mediaPpm());
        System.out.printf("Media tensión sistólica: %.0f\n", preRev[2]);
        //System.out.printf("Media tensión sistólica: %.0f", centro.mediaTenSis());
        System.out.printf("Media tensión diastólica: %.0f\n", preRev[3]);
        //System.out.printf("Media tensión diastólica: %.0f", centro.mediaTenDias());
        System.out.printf("Media edad pacientes: %.1f\n", centro.mediaEdadPacientes());
        System.out.printf("Porcentaje hombres: %.2f\n", centro.porcentajeHombres());
        System.out.printf("Porcentaje mujeres: %.2f\n", centro.porcentajeMujeres());
        Lib.pause();
    }

    private void consultaPorFechas() {
        boolean validado;
        int i;
        System.out.println("Fecha inicio (dd-mm-yyyy): ");
        String fechaInicioStr = lector.nextLine();
        GregorianCalendar fechaInicio = null;
        GregorianCalendar fechaFin = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        try {
            Date date = sdf.parse(fechaInicioStr + " 00:00");
            fechaInicio = new GregorianCalendar();
            fechaInicio.setTime(date);
            validado = true;
        } catch (ParseException pe) {
            validado = false;
            System.out.println("El formato de la fecha inicio no es correcto. Recuerde (dd-mm-yyyy).");
            Lib.pause();
        }
        if(validado) {
            System.out.println("Fecha fin (dd-mm-yyyy): ");
            String fechaFinStr = lector.nextLine();
            if(fechaFinStr.equals("")) {
                fechaFin = new GregorianCalendar();
                validado = true;
            } else {
                try {
                    Date date = sdf.parse(fechaFinStr + " 23:59");
                    fechaFin = new GregorianCalendar();
                    fechaFin.setTime(date);
                    validado = true;
                } catch (ParseException pe) {
                    validado = false;
                    System.out.println("El formato de la fecha fin no es correcto. Recuerde (dd-mm-yyyy).");
                    Lib.pause();
                }
            }
            if(validado) {
                AtencionMedica[] historialFechas = centro.buscarHistoricoPorFechas(fechaInicio, fechaFin);
                if (historialFechas != null) {
                    for (i = 0; i < historialFechas.length; i++) {
                        System.out.println(historialFechas[i].toString());
                    }
                } else {
                    System.out.println("No se han encontrado registros");
                }
            }
        }
        Lib.pause();
    }

    private void consultaPorSip() {
        int i;
        int sip;
        System.out.println("Sip: ");
        sip = Integer.parseInt(lector.nextLine());
        AtencionMedica[] historialSip = centro.buscarHistoricoPorSip(sip);
        if (historialSip != null) {
            for (i = 0; i < historialSip.length; i++) {
                System.out.println(historialSip[i].toString());
            }
        } else {
            System.out.println("No se han encontrado registros");
        }
        Lib.pause();
    }
}
