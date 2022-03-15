package Tema8.EjemplosTema8.Medico;

import Tema8.EjemplosTema8.utils.*;

import java.util.GregorianCalendar;

public class Cita {
    private GregorianCalendar fecha;
    private Paciente paciente;
    private String codigo;
    private static int nCitas;
    private static char[] letras = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
    private static int primeraLetra = Lib.aleatorio(0,letras.length-1);
    private static int segundaLetra = Lib.aleatorio(0, letras.length-1);

    public Cita(GregorianCalendar fecha, Paciente paciente) {
        this.fecha = fecha;
        this.paciente = paciente;

        nCitas++;
        codigo = obtenerNumero();
    }

    private String obtenerNumero() {
        int numero = nCitas % 10;
        if(numero == 0) {
            segundaLetra++;
            if(segundaLetra == letras.length-1) {
                segundaLetra = 0;
                primeraLetra++;
            }
            if(primeraLetra == letras.length-1) {
                primeraLetra = 0;
            }
        }
        codigo = ""+ letras[primeraLetra] + numero + letras[segundaLetra];
        return codigo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "paciente=" + paciente +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
