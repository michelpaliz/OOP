package Tema8.EjemplosTema8.Medico;

import java.util.GregorianCalendar;

public class Medico {
    private static final int MAX_CITAS_ACTIVAS = 100;
    private int numColegiado;
    private String nombre;
    private String apellidos;
    private int nCitas;
    private ColaCitas cola;
    private int puerta;

    public Medico(int numColegiado, String nombre, String apellidos, int puerta) {
        this.numColegiado = numColegiado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.puerta = puerta;
        this.nCitas = 0;
        this.cola = null;
    }

    public void generarCitasAleatorias(int numCitas, Paciente[] pacientes) {
        if(cola == null) {
            cola = new ColaCitas(MAX_CITAS_ACTIVAS);
            for(int i = 0; i < numCitas; i++) {
                cola.add(new Cita(new GregorianCalendar(), pacientes[i]));
                this.nCitas++;
            }
        }
    }

    public int getNumColegiado() {
        return numColegiado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getPuerta() {
        return puerta;
    }

    public Cita[] getCitas() {
        return cola.getCitas();
    }

    public int getnCitas() {
        return this.nCitas;
    }

    public String nuevaCita(Paciente paciente) {
        Cita cita = new Cita(new GregorianCalendar(), paciente);
        cola.add(cita);
        return cita.getCodigo();
    }

    public String siguientePaciente() {
        Cita cita = cola.remove();
        if(cita != null) {
            return cita.getCodigo();
        }
        return null;
    }
}
