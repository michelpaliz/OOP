package com.germangascon.tema08.ejercicio07;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class AtencionMedica {
    public enum MotivoAlta {
        MEJORA, DERIVACION_HOSPITAL, DEFUNCION;

        @Override
        public String toString() {
            switch (this) {
                case MEJORA:
                    return "Mejora";
                case DERIVACION_HOSPITAL:
                    return "Derivación hospital";
                case DEFUNCION:
                    return "Defunción";
                default: throw new IllegalArgumentException();
            }
        }

        public static MotivoAlta fromInteger(int x) {
            switch (x) {
                case 0:
                    return MEJORA;
                case 1:
                    return DERIVACION_HOSPITAL;
                case 2:
                    return DEFUNCION;
            }
            return null;
        }

    }
    private final Paciente paciente;
    private final GregorianCalendar fechaEntrada;
    private final String sintomatologia;
    private final float[] preRev;
    private GregorianCalendar fechaAlta;
    private MotivoAlta motivoAlta;
    private boolean atendido;

    public AtencionMedica(Paciente paciente, String sintomatologia) {
        this.paciente = paciente;
        this.sintomatologia = sintomatologia;
        this.fechaEntrada = new GregorianCalendar();
        this.fechaAlta = null;
        this.preRev = new float[4];
        this.atendido = false;
    }

    public AtencionMedica(Paciente paciente, String sintomatologia, GregorianCalendar fechaEntrada, float temperatura, float ppm, float tenSis, float tenDias, GregorianCalendar fechaAlta, MotivoAlta motivoAlta) {
        this.paciente = paciente;
        this.sintomatologia = sintomatologia;
        this.fechaEntrada = fechaEntrada;
        this.preRev = new float[4];
        this.preRev[0] = temperatura;
        this.preRev[1] = ppm;
        this.preRev[2] = tenSis;
        this.preRev[3] = tenDias;
        this.fechaAlta = fechaAlta;
        this.motivoAlta = motivoAlta;
        this.atendido = true;
    }

    public boolean atender(float temperatura, float ppm, float tenSis, float tenDias) {
        if(fechaAlta == null) {
            atendido = true;
            this.preRev[0] = temperatura;
            this.preRev[1] = ppm;
            this.preRev[2] = tenSis;
            this.preRev[3] = tenDias;
            return true;
        }
        return false;
    }

    public boolean darAlta(MotivoAlta motivoAlta) {
        if(fechaAlta == null) {
            fechaAlta = new GregorianCalendar();
            this.motivoAlta = motivoAlta;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdfFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
        String nombre = paciente.getNombre();
        String apellido1 = paciente.getApellido1();
        String result = String.format("%10d", paciente.getSip()) + "\t" +
                String.format("%-24s", paciente.getNombre() + " " + paciente.getApellido1()) +
                String.format("%-14s", sdfFecha.format(fechaEntrada.getTime())) +
                String.format("%-6s", sdfHora.format(fechaEntrada.getTime())) +
                String.format("%4d", paciente.getEdad()) + "\t" +
                String.format("%-28s", sintomatologia);
                if(preRev[0] != 0) {
                    result += String.format("%5.1f", preRev[0]) +
                            String.format("%5.0f", preRev[1]) +
                            String.format("%5.0f", preRev[2]) +
                            String.format("%5.0f", preRev[3]) + "\t";
                }
                if(fechaAlta != null) {
                    result += String.format("%-14s", sdfFecha.format(fechaAlta.getTime())) +
                            String.format("%-8s", sdfHora.format(fechaAlta.getTime())) +
                            String.format("%-12s", motivoAlta);
                }
        return result;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public GregorianCalendar getFechaEntrada() {
        return fechaEntrada;
    }

    public String getSintomatologia() {
        return sintomatologia;
    }

    public float[] getPreRev() {
        return preRev;
    }

    public GregorianCalendar getFechaAlta() {
        return fechaAlta;
    }

    public MotivoAlta getMotivoAlta() {
        return motivoAlta;
    }

    public boolean isAtendido() {
        return atendido;
    }
}
