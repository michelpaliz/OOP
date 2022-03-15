package Tema8.EjemplosTema8;

public class Persona {
    String dni;
    String nombre;
    String apellidos;
    int edad;
    Genero genero; //es un tipo de datos mas complejo de escoger;


    public Persona(String dni, String nombre) { //si esta gris persona es que no se esta usuando
        this.dni = dni;
        this.nombre = nombre;
    }

    public Persona() {
        dni = "no valido";//si no hay nada escrito en dni, esto se escibira
    }

    //el constructor puede estar sobrecargado
    public Persona(int edad, String nombre) {
        this.edad = edad;  //permito que tenga  otro parametro de otro tipo de valor primitivo
        this.nombre = nombre;
    }

    //este es el contructor de la clase
    public Persona(String dni, String nombre, String apellidos, int edad, Genero genero) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.genero = genero;

//        dni = "no tiene sentido";
//        nombre = "Jhon Bee";
//        apellidos = "Doe";
//        //int edad = 99; //esta variable oculta las externas, asignarle el valor al atributo
//        edad = 99;
//        genero = Genero.FEMENINO;

    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellidos + '\'' +
                ", edad=" + edad +
                ", genero=" + genero +
                '}';
    }
//    char genero;


}
