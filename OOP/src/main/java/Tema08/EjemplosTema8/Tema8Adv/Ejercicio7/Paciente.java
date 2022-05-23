package Tema08.EjemplosTema8.Tema8Adv.Ejercicio7;

public class Paciente {
    public enum Sexo {
        M, V
    }
    private long sip;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Sexo sexo;
    private int edad;
    private String codigo;

    public Paciente(long sip, String nombre, String apellido1, String apellido2, Sexo sexo, int edad) {
        this.sip = sip;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.sexo = sexo;
        this.edad = edad;
    }

    public long getSip() {
        return sip;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return String.format("%10d", sip) + "\t" +
                String.format("%-12s", nombre ) +
                String.format("%-12s", apellido1) +
                String.format("%-12s", apellido2) +
                String.format("%-4s", sexo) +
                String.format("%4d", edad);

    }
}
