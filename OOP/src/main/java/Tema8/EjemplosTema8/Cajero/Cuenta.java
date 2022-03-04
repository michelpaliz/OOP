package Tema8.EjemplosTema8.Cajero;

public class Cuenta {
    //Creamos los atributos
    private int numeroSeguridad;
    private int pin;
    private String numeroTarjeta;

    //**crearemos construtores
    public Cuenta() {
        numeroTarjeta = "*******";
        pin = 123456;
        numeroSeguridad = 123;
    }

    public Cuenta(String numeroTarjeta, int pin, int numeroSeguridad) {
        this.numeroTarjeta = numeroTarjeta;
        this.pin = pin;
        this.numeroSeguridad = numeroSeguridad;
    }

    //*METODOS**/
    //**Generamos el metodo toString\
    @Override
    public String toString() {
        return "Cuenta{" +
                "numeroTarjeta='" + numeroTarjeta + '\'' +
                ", pin=" + pin +
                ", numeroSeguridad=" + numeroSeguridad +
                '}';
    }

    public int getPin() {
        return pin;
    }

    public int getNumeroSeguridad() {
        return numeroSeguridad;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }
}
