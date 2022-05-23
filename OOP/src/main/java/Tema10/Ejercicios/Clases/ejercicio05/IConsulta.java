package Tema10.Ejercicios.Clases.ejercicio05;

import java.util.ArrayList;
import java.util.HashMap;

public interface IConsulta {

    int[] majorMenorArray(ArrayList<Paciente> pacientes);

    int[] pacientsPorSexoArray(ArrayList<Paciente> pacientes);

    double imc(Paciente paciente);

    int edad(Paciente paciente);

    HashMap<String, String> imcMensaje(ArrayList<Paciente> pacientes);
}
