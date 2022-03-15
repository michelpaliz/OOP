package Tema8.EjemplosTema8.ejercicio03;

import Tema8.EjemplosTema8.Cajero.util.Bombo;

import com.github.javafaker.Faker;

import java.util.Date;
import java.util.GregorianCalendar;


public class Instituto {
    private Alumno[] alumnos;
    private int nAlumnos;


    public Instituto(int minAlumnos) {
        alumnos = new Alumno[minAlumnos];
        nAlumnos = 0;
        if(Ejercicio03.DEBUG) {
            crearDatosPrueba(minAlumnos / 2);
        }
    }

    private void crearDatosPrueba(int cantidad) {
        Bombo bombo = new Bombo(cantidad, 1);
        Faker faker = new Faker();
        for(int i = 0; i < cantidad; i++) {
            int nia = bombo.extraerBola();
            String nombre = faker.name().name();
            String apellidos = faker.name().lastName();
            Date fecha = faker.date().birthday(18, 40);
            String grupo = faker.beer().name();
            String telefono = faker.phoneNumber().phoneNumber();

            GregorianCalendar fechaNacimiento = new GregorianCalendar();
            fechaNacimiento.setTime(fecha);
            alumnos[i] = new Alumno(nia, nombre, apellidos, fechaNacimiento, grupo, telefono);
            System.out.println(alumnos[i]);
            nAlumnos++;
        }
    }

    public Alumno nuevoAlumno(long nia, String nombre, String apellidos, GregorianCalendar fechaNacimiento, String grupo, String telefono) {
        // Posible validación
        if(buscarAlumnoPorNia(nia) != null)
            return null;
        if(nAlumnos == alumnos.length) {
            Alumno[] alumnosAmpliado = new Alumno[(int)(nAlumnos * Ejercicio03.FACTOR_CRECIMIENTO)];
            for(int i = 0; i < alumnos.length; i++) {
                alumnosAmpliado[i] = alumnos[i];
            }
            alumnos = alumnosAmpliado;
        }
        Alumno nuevoAlumno = new Alumno(nia, nombre, apellidos, fechaNacimiento, grupo, telefono);
        alumnos[nAlumnos] = nuevoAlumno;
        nAlumnos++;
        return nuevoAlumno;
    }

    public boolean eliminarAlumno(long nia) {
        int pos = buscarAlumno(nia);
        if(pos < 0)
            return false;
        alumnos[pos] = alumnos[nAlumnos -1];
        alumnos[nAlumnos - 1] = null;
        nAlumnos--;
        return true;
    }

    public int buscarAlumno(long nia) {
        for(int i = 0; i < nAlumnos; i++) {
            if(alumnos[i].getNia() == nia)
                return i;
        }
        return -1;
    }

    public Alumno buscarAlumnoPorNia(long nia) {
        int pos = buscarAlumno(nia);
        return pos < 0 ? null : alumnos[pos];
    }

    public Alumno[] buscarAlumnosPorGrupo(String grupo) {
        Alumno[] alumnosGrupo;
        int contador = 0;
        int alumnosInsertados = 0;
        for(int i = 0; i < nAlumnos; i++) {
            if(alumnos[i].getGrupo().equalsIgnoreCase(grupo)) {
                contador++;
            }
        }
        if(contador > 0) {
            alumnosGrupo = new Alumno[contador];
            for (int i = 0; i < nAlumnos; i++) {
                if (alumnos[i].getGrupo().equalsIgnoreCase(grupo)) {
                    alumnosGrupo[alumnosInsertados++] = alumnos[i];
                }
            }
            return alumnosGrupo;
        }
        return null;
    }

    public Alumno[] buscarAlumosPorEdad(int edad) {
        Alumno[] alumnosEdad;
        int contador = 0;
        int alumnosInsertados = 0;
        for(int i = 0; i < nAlumnos; i++) {
            if(alumnos[i].getEdad() == edad) {
                contador++;
            }
        }
        if(contador > 0) {
            alumnosEdad = new Alumno[contador];
            for (int i = 0; i < nAlumnos; i++) {
                if (alumnos[i].getEdad() == edad) {
                    alumnosEdad[alumnosInsertados++] = alumnos[i];
                }
            }
            return alumnosEdad;
        }
        return null;
    }

    public Alumno[] buscarAlumnosPorApellidos(String apellidos) {
        Alumno[] alumnosApellidos;
        int contador = 0;
        int alumnosInsertados = 0;
        for(int i = 0; i < nAlumnos; i++) {
            if(alumnos[i].getApellidos().toLowerCase().startsWith(apellidos.toLowerCase())) {
                contador++;
            }
        }
        if(contador > 0) {
            alumnosApellidos = new Alumno[contador];
            for (int i = 0; i < nAlumnos; i++) {
                if (alumnos[i].getApellidos().
                        toLowerCase().startsWith(apellidos.toLowerCase())) {
                    alumnosApellidos[alumnosInsertados++] = alumnos[i];
                }
            }
            return alumnosApellidos;
        }
        return null;
    }

}

















