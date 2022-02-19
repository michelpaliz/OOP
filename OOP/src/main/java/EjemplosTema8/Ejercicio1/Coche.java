package EjemplosTema8.Ejercicio1;


import org.w3c.dom.ls.LSOutput;

public class Coche {
    //tipos de datos para representar
    private String modelo;
    private Color color;//una variable que puede alamacenar tipo pintura
    private boolean metalizado;
    private String matricula;
    private Tipo tipoCoche;
    private int anyoFabricacion;
    private modalidadSeguro modalidadSeguro; //modalidadSeguro la primera con mayuscula que es el nombre de la clase

    //************************
    public Coche() {
        modelo = "Sin modelo";
        color = Color.BLANCO;
        matricula = "Sin matricula";
        tipoCoche = Tipo.UTILITARIO;
        anyoFabricacion = 2017;
        modalidadSeguro = modalidadSeguro.TERCERO;
    }

    public Coche(String modelo, Color color, boolean metalizado, String matricula, Tipo tipoCoche, int anyoFabricacion, EjemplosTema8.Ejercicio1.modalidadSeguro modalidadSeguro) {
        this.modelo = modelo;
        this.color = color;
        this.metalizado = metalizado;
        this.matricula = matricula;
        this.tipoCoche = tipoCoche;
        this.anyoFabricacion = anyoFabricacion;
        this.modalidadSeguro = modalidadSeguro;
    }


    //Ahora creamos el constructor de la clase coche
    //Solo ponemos los que son creamos que son obligatorios
    public Coche(String modelo, String matricula) {
        this.modelo = modelo; //el parametro se llama igual que el atributo asi que por eso ponemos THIS.
        this.matricula = matricula;//valdria null
    }

    //code ---- generate --- toString
    @Override //esto es como una alarma si no esta escrito bien el metodo
    public String toString() {
        return "Coche{" +
                "modelo='" + modelo + '\'' +
                ", color=" + color +
                ", metalizado=" + metalizado +
                ", matricula='" + matricula + '\'' +
                ", tipoCoche=" + tipoCoche +
                ", anyoFabricacion=" + anyoFabricacion +
                ", modalidadSeguro=" + modalidadSeguro +
                '}';
    }

    //este metodo no es reutilizable
    public String imprimirCoche() {

        return "Modelo " + modelo + ", Color :" + color;
    }

    public void cambiarColor(Color color) {
        if (modelo == "Ibiza" && color == Color.AMARILLO) {
            return;
        }
        this.color = color;
    }

    //getters no llevan atributos, si damos el acceso al atributo no tendriamos el control
    public String getModelo() {
        return modelo;
    }

    //Setters
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    //Creacion de getter
    public Color getColor() {
        return color;
    }

    public boolean isMetalizado() {
        return metalizado;
    }

    public String getMatricula() {
        return matricula;
    }

    public Tipo getTipoCoche() {
        return tipoCoche;
    }

    public int getAnyoFabricacion() {
        return anyoFabricacion;
    }

    public EjemplosTema8.Ejercicio1.modalidadSeguro getModalidadSeguro() {
        return modalidadSeguro;
    }

    //********************
    public enum Tipo {
        MINI, UTILITARIO, FAMILIAR, DEPODRTIVO
    }
}
