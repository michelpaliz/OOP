package Tema9.EjerciciosTm9.Ejercicio5;

import Util.Lib;

public class Ejercicio5 {

    private static final int INITIAL_ALUMNOS_SIZE = 5;
    private Alumno[] alumnos;;
    private int alumnosCount;

    public void Ejercicio5() {
        String mgInt = "Introduce un numero";
        String mgStr = "Introduce el nombre del alumno";
        String mgDouble = "Introduce la altura del alumno";
        Alumno alumno1 = new Alumno(Lib.validarStr0(mgStr, 1, 10), Lib.validarInt(mgInt, 1, 100),
                Lib.validateDouble(mgDouble));

        Alumno alumno2 = new Alumno(Lib.validarStr0(mgStr, 1, 10), Lib.validarInt(mgInt, 1, 100),
                Lib.validateDouble(mgDouble));
        System.out.println("Sacamos el alumno mayor");
        System.out.println(compararObj(alumno1, alumno2));

        alumnosCount = 0;
        alumnos = new Alumno[INITIAL_ALUMNOS_SIZE];
        

        System.out.println(apartadoB(2));


    }



    public Alumno compararObj(Alumno alumno1, Alumno alumno2) {
        Alumno alumno = (null);

        if (alumno1.getEdad() > alumno2.getEdad()) {
            alumno = alumno1;
        } else {
            alumno = alumno2;
        }

        return alumno;
    }


    public void solicitarAlumno(){
        String nombre = Lib.validarStr0("nombre", 0, 100);
        int userInt = 0;
        do {
            try {
                System.out.print("edad");
                userInt = Integer.parseInt(Lib.myInput.nextLine());
                Lib.correct = userInt >= 0 && userInt <= 100;
                if (!Lib.correct) {
                    System.out.println("El numero debe estar entre" + 0 + " y " + 100);
                }
            } catch (NumberFormatException e) {
                System.out.println("Error");
                Lib.pausa();
            }
        
        } while (!Lib.correct);
        int edad = userInt;
        double altura = Lib.validateDouble("Altura");
        
        alumnos[alumnosCount++] = new Alumno(nombre, edad, altura);
    }


    public void addAlumno(String nombre, int edad, int altura){
        alumnos[alumnosCount] = new Alumno(nombre,edad,altura);
        alumnosCount++;
        
    }

    public Alumno apartadoB(int nAlumno){
        Alumno mayor= null;
        for(int i = 0; i < nAlumno; i++) {
         addAlumno("nombre" + i, Lib.random(6, 30), Lib.random(50, 200)); 
        }
        if(alumnos[alumnosCount-1].getEdad() > alumnos[alumnosCount-2].getEdad()){
            mayor =(alumnos[alumnosCount-1]);;
        }else{
            mayor = (alumnos[alumnosCount-2]);
        }

        return mayor;
    }

    public void apartadoA(){
        solicitarAlumno();;
    }




}
