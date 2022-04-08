package Tema08.EjemplosTema8.Tema8Adv.Ejercicio1;

public class Coche {
    public enum Tipo {
        MINI, UTILITARIO, FAMILIAR, DEPORTIVO
    }
    private String modelo;
    private Color color;
    private boolean metalizada;
    private String matricula;
    private Tipo tipoCoche;
    private int anyoFabricacion;
    private ModalidadSeguro modalidadSeguro;

    public Coche() {
        modelo = "SIN MODELO";
        color = Color.BLANCO;
        metalizada = false;
        matricula = "SIN MATRICULA";
        tipoCoche = Tipo.UTILITARIO;
        anyoFabricacion = 2017;
        modalidadSeguro = ModalidadSeguro.TERCEROS;
    }

    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
    }

    public Coche(String modelo, Color color, boolean metalizada, String matricula, Tipo tipoCoche, int anyoFabricacion, ModalidadSeguro modalidadSeguro) {
        this.modelo = modelo;
        this.color = color;
        this.metalizada = metalizada;
        this.matricula = matricula;
        this.tipoCoche = tipoCoche;
        this.anyoFabricacion = anyoFabricacion;
        this.modalidadSeguro = modalidadSeguro;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isMetalizada() {
        return metalizada;
    }

    public void setMetalizada(boolean metalizada) {
        this.metalizada = metalizada;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Tipo getTipoCoche() {
        return tipoCoche;
    }

    public void setTipoCoche(Tipo tipoCoche) {
        this.tipoCoche = tipoCoche;
    }

    public int getAnyoFabricacion() {
        return anyoFabricacion;
    }

    public void setAnyoFabricacion(int anyoFabricacion) {
        this.anyoFabricacion = anyoFabricacion;
    }

    public ModalidadSeguro getModalidadSeguro() {
        return modalidadSeguro;
    }

    public void setModalidadSeguro(ModalidadSeguro modalidadSeguro) {
        this.modalidadSeguro = modalidadSeguro;
    }

    public String imprimirCoche() {
        return "Modelo: " + modelo + ", Color: " + color;
    }


    @Override
    public String toString() {
        return "Coche{" +
                "modelo='" + modelo + '\'' +
                ", color=" + color +
                ", metalizada=" + metalizada +
                ", matricula='" + matricula + '\'' +
                ", tipoCoche=" + tipoCoche +
                ", anyoFabricacion=" + anyoFabricacion +
                ", modalidadSeguro=" + modalidadSeguro +
                '}';
    }
}
