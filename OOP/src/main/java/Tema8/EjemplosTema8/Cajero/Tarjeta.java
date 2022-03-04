package Tema8.EjemplosTema8.Cajero;

public class Tarjeta {
    //*Atributos
    private String propietario;
    private double saldo;
    private Tipo tarjeta;

    //**METODOS ***//
    public Tarjeta() {
        propietario = "Sin propietario";
        String saldo = "no definido";
        tarjeta = Tipo.DEBITO;
    }

    //Constructores para asignar valores
    public Tarjeta(String propietario, int saldo, Tipo tarjeta) {
        this.propietario = propietario;
        this.saldo = saldo;
        this.tarjeta = tarjeta;
    }

    public double ingresoNuevo(double importe) {
        importe = saldo;
        return saldo;
    }

    public boolean ingreso(double saldo) {
        boolean valido;
        if (saldo > 1) {
            System.out.println("El ingreso es valido");
            valido = true;

        } else {
            System.out.println("El ingreso no es valdio");
            valido = false;
        }
        return valido;
    }

    public double extraccion(double importe, double saldo) {
        double resultado = saldo - importe;
        return resultado;
    }

    //Metodo toString para printar los atributos que hemos creado antes ya que son direcciones de memoria;
    @Override
    public String toString() {
        return "Tarjeta{" +
                "propietario='" + propietario + '\'' +
                ", saldo=" + saldo +
                ", tarjeta=" + tarjeta +
                '}';
    }

    //*generar setter

    public String getPropietario() {
        return propietario;
    }

    //*generacion de getter

    public double getSaldo() {
        return saldo;
    }

    public Tipo getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tipo tarjeta) {
        this.tarjeta = tarjeta;
    }

    //Generamos los atributos
    public enum Tipo {
        CREDITO, DEBITO
    }
}


