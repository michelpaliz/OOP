package Tema8.EjemplosTema8.Tema8Adv.Ejercicio7;
import Tema8.EjemplosTema8.utils.*;

import java.util.Scanner;

public class Ejercicio4 {
    public static final int MAX_PACIENTES = 500;
    public static final int MAX_MEDICOS = 30;
    private Scanner lector;
    private CentroSalud centro;

    public Ejercicio4() {
        lector = new Scanner(System.in);
        int opcion;
        centro = new CentroSalud(MAX_PACIENTES, MAX_MEDICOS);
        centro.generarDatosAleatorios(100, 5, 10);
        do {
            opcion = menuPrincipal();
            switch (opcion) {
                case 1:
                    nuevaCita();
                    break;
                case 2:
                    atenderPaciente();
                    break;
                case 3:
                    consultas();
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    break;
            }
        } while (opcion != 0);

        lector.close();
    }

    private void atenderPaciente() {
        int numColegiado;
        Medico medico = null;
        String codigo = null;
        System.out.println("Seleccione el médico: ");
        numColegiado = menuMedicos();
        if(numColegiado != 0) {
            medico = centro.buscarMedico(numColegiado);
            codigo = medico.siguientePaciente();
            if(codigo != null) {
                System.out.println("Siguiente paciente: " + codigo);
            } else {
                System.out.println("No hay pacientes en espera");
            }
            Lib.pausa();
        }
    }

    private void nuevaCita() {
        int sip;
        boolean validado = false;
        int numColegiado;
        Paciente paciente = null;
        Medico medico = null;
        do {
            System.out.println("Sip: ");
            sip = Integer.parseInt(lector.nextLine());
            paciente = centro.buscarPacientePorSip(sip);
            validado = paciente !=null;
            if(!validado) {
                System.out.println("No existe ningún paciente con el sip " + sip);
            }
        } while(!validado);

        System.out.println("Seleccione el médico: ");
        numColegiado = menuMedicos();
        if(numColegiado != 0) {
            medico = centro.buscarMedico(numColegiado);
            System.out.println("Su código es: " + medico.nuevaCita(paciente));
        }
    }

    private int menuPrincipal() {
        int opcion = -1;
        do {
            Lib.limpiarPantalla();
            System.out.println("*********************");
            System.out.println("** H O S P I T A L **");
            System.out.println("*********************");
            System.out.println("1. Introducir SIP...");
            System.out.println("2. Llamar a paciente...");
            System.out.println("3. Consultas...");
            System.out.println("---------------------");
            System.out.println("0. Salir\n");
            System.out.println("Elija una opción: ");
            opcion = Integer.parseInt(lector.nextLine());
            if (opcion < 0 || opcion > 3) {
                System.out.println("Elija una opción del menú [0-3]");
                Lib.pausa();
            }

        } while (opcion < 0 || opcion > 3);
        return opcion;
    }

    private int menuConsultas() {
        int opcion = -1;
        do {
            Lib.limpiarPantalla();
            System.out.println("*********************");
            System.out.println("**    CONSULTAS    **");
            System.out.println("*********************");
            System.out.println("1. Citas de un paciente...");
            System.out.println("2. Citas de un médico...");
            System.out.println("3. Mostrar todos los pacientes");
            System.out.println("4. Mostrar todas las citas");
            System.out.println("------------------------");
            System.out.println("0. Volver al menú principal\n");
            System.out.println("Elija una opción: ");
            opcion = Integer.parseInt(lector.nextLine());
            if(opcion < 0 || opcion > 4) {
                System.out.println("Elija una opción del menú [0-4]");
                Lib.pausa();
            }
        } while (opcion < 0 || opcion > 4);
        return opcion;
    }

    private void consultas() {
        int opcion;
        do {
            opcion = menuConsultas();
            switch (opcion) {
                case 1:
                    //Por sip
                    consultaPorSip();
                    break;
                case 2:
                    //Por Médico
                    consultaPorMedico();
                    break;
                case 3:
                    //Mostrar todos los pacientes
                    mostrarPacientes();
                    break;
                case 4:
                    //Mostrar todas las citas
                    mostrarCitas();
                    break;
            }
        } while (opcion != 0);
    }

    private void consultaPorSip() {
        int sip;
        Cita[] citas = null;
        System.out.println("Sip: ");
        sip = Integer.parseInt(lector.nextLine());
        citas = centro.buscarCitasPorSip(sip);
        if(citas != null) {
            for(int i = 0; i < citas.length; i++) {
                System.out.println(citas[i].toString());
            }
        } else {
            System.out.println("No se han encontrado citas");
        }
    }

    private int menuMedicos() {
        int opcion = -1;
        Medico medico = null;
        Medico[] medicos = centro.getMedicos();
        do {
            Lib.limpiarPantalla();
            System.out.println("*******************");
            System.out.println("** M É D I C O S **");
            System.out.println("*******************");
            for(int i = 0; i < medicos.length; i++) {
                System.out.println(medicos[i].getNumColegiado() + ". " + medicos[i].getNombre() + " " + medicos[i].getApellidos());
            }
            System.out.println("------------------------");
            System.out.println("0. Volver al menú principal\n");
            System.out.println("Elija una opción: ");
            opcion = Integer.parseInt(lector.nextLine());

            medico = centro.buscarMedico(opcion);
            if(opcion < 0 || medico == null) {
                System.out.println("Elija una opción del menú");
                Lib.pausa();
            }
        } while (opcion < 0 || medico == null);
        return opcion;
    }

    private void consultaPorMedico() {
        int opcion = menuMedicos();
        switch (opcion) {
            case 0:
                menuPrincipal();
                break;
            default:
                Cita[] citas = centro.buscarCitasPorMedico(opcion);
                for(int i = 0; i < citas.length; i++) {
                    System.out.println(citas[i].toString());
                }
        }
    }


    private void mostrarCitas() {
        Cita[] citas = centro.getCitas();
        for(int i = 0; i < citas.length; i++) {
            System.out.println(citas[i].toString());
        }
    }

    private void mostrarPacientes() {
        Paciente[] pacientes = centro.getPacientes();
        for(int i = 0; i < pacientes.length; i++) {
            System.out.println(pacientes[i].toString());
        }
    }
}
