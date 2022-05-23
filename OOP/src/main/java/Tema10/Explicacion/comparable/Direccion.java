package Tema10.Explicacion.comparable;

public class Direccion implements Cloneable {
    private String calle;
    private String ciudad;
    private int codigoPostal;

    public Direccion(Direccion d) {
        this(d.calle, d.ciudad, d.codigoPostal);
    }

    public Direccion(String calle, String ciudad, int codigoPostal) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

}
