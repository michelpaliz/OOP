package Tema8.EjemplosTema8.Tema8Adv.Cajero;

public class Empresa {
    private final char codigo;
    private final String nombre;
    private final Banco[] bancos;

    public Empresa(char codigo, String nombre, Banco[] bancos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.bancos = bancos;
    }

    public char getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Banco getBanco(String numTarjeta) {
        String codigoBanco = numTarjeta.substring(1, 6);
        for(Banco banco: bancos) {
            if (banco.getCodigo().equals(codigoBanco))
                return banco;
        }
        return null;
    }

    public boolean validarCredenciales(String numTarjeta, String pin) {
        Banco banco = getBanco(numTarjeta);
        if(banco != null)
            return banco.validarCredenciales(numTarjeta, pin);
        return false;
    }

    public boolean ingresar(String numTarjeta, double cantidad) {
        Banco banco = getBanco(numTarjeta);
        if(banco != null)
            return banco.ingresar(numTarjeta, cantidad);
        return false;
    }

    public double retirar(String numTarjeta, double cantidad) {
        Banco banco = getBanco(numTarjeta);
        if(banco != null)
            return banco.retirar(numTarjeta, cantidad);
        return -1;
    }

    public double consultarSaldo(String numTarjeta) {
        Banco banco = getBanco(numTarjeta);
        if(banco != null)
            return banco.consultarSaldo(numTarjeta);
        return Long.MIN_VALUE;
    }

    public String cambiarPin(String numTarjeta, String oldPin, String newPin) {
        Banco banco = getBanco(numTarjeta);
        if(banco != null)
            return banco.cambiarPin(numTarjeta, oldPin, newPin);
        return oldPin;
    }

}
