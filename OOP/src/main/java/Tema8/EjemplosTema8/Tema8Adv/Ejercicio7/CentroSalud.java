package Tema8.EjemplosTema8.Tema8Adv.Ejercicio7;

import Tema8.EjemplosTema8.utils.*;
import com.github.javafaker.Faker;
import java.util.Locale;

public class CentroSalud {
    private Paciente[] pacientes;
    private Medico[] medicos;

    private int nPacientes;
    private int nMedicos;
    private int lastSIP = 10103001;

    public CentroSalud(int maxPacientes, int maxMedicos) {
        this.pacientes = new Paciente[maxPacientes];
        this.medicos = new Medico[maxMedicos];
        this.nPacientes = 0;
        this.nMedicos = 0;
    }

    public void generarDatosAleatorios(int numPacientes, int numMedicos, int citasPorMedico) {
        generarPacientesAleatorios(numPacientes);
        generarMedicosAleatorios(numMedicos, citasPorMedico);
    }

    private void generarPacientesAleatorios(int numPacientes) {
        Faker faker = new Faker(new Locale("es"));
        int sip;
        String nombre;
        String apellido1;
        String apellido2;
        Paciente.Sexo sexo;
        int edad;
        for(int i = 0; i < numPacientes; i++) {
            sip = ++lastSIP;
            nombre = faker.name().firstName();
            apellido1 = faker.name().lastName();
            apellido2 = faker.name().lastName();
            sexo = Lib.aleatorio(0, 1) == 0 ? Paciente.Sexo.M : Paciente.Sexo.V;
            edad = Lib.aleatorio(1, 90);
            pacientes[i] = new Paciente(sip, nombre, apellido1, apellido2, sexo, edad);
            this.nPacientes++;
        }
    }

    private void generarMedicosAleatorios(int numMedicos, int nCitas) {
        Faker faker = new Faker(new Locale("es"));
        for(int i = 0; i < numMedicos; i++) {
            medicos[i] = new Medico(i+1, faker.name().firstName(), faker.name().lastName(), i+1);
            medicos[i].generarCitasAleatorias(nCitas, pacientes);
            this.nMedicos++;
        }
    }

    public Paciente[] getPacientes() {
        Paciente[] pacientesReales = new Paciente[nPacientes];
        for(int i = 0; i < nPacientes; i++) {
            pacientesReales[i] = pacientes[i];
        }
        return pacientesReales;
    }



    public Medico[] getMedicos() {
        Medico[] medicosReales = new Medico[nMedicos];
        for(int i = 0; i < nMedicos; i++) {
            medicosReales[i] = medicos[i];
        }
        return medicosReales;
    }

    public Cita[] getCitas() {
        int totalCitas = 0;
        int cont = 0;
        Cita[] citas = null;
        for(int i = 0; i < nMedicos; i++) {
            totalCitas += medicos[i].getnCitas();
        }
        citas = new Cita[totalCitas];
        for(int i = 0; i < nMedicos; i++) {
            Cita[] citasMedico = medicos[i].getCitas();
            for(int j = 0; j < medicos[i].getnCitas(); j++) {
                citas[cont] = citasMedico[j];
                cont++;
            }
        }
        return citas;
    }

    public Medico buscarMedico(int numColegiado) {
        for(int i = 0; i < nMedicos; i++) {
            if(medicos[i].getNumColegiado() == numColegiado) {
                return medicos[i];
            }
        }
        return null;
    }

    public Paciente buscarPacientePorSip(int sip) {
        for(int i = 0; i < nPacientes; i++) {
            if(pacientes[i].getSip() == sip) {
                return pacientes[i];
            }
        }
        return null;
    }


    public Cita[] buscarCitasPorSip(int sip) {
        boolean fin = false;
        int nCitasPaciente = 0;
        Cita[] citasSip = null;
        for(int i = 0; i < nMedicos; i++) {
            if(medicos[i]!= null) {
                Cita[] citas = medicos[i].getCitas();
                for (int j = 0; j < medicos[i].getnCitas(); j++) {
                    if (citas[j].getPaciente().getSip() == sip) {
                        nCitasPaciente++;
                    }
                }
            }
        }
        if(nCitasPaciente > 0) {
            citasSip = new Cita[nCitasPaciente];
            int cont = 0;
            /** Una vez sabemos el número de citas del paciente los asignamos al vector **/
            for(int i = 0; i < nMedicos; i++) {
                if(medicos[i]!= null) {
                    Cita[] citas = medicos[i].getCitas();
                    for (int j = 0; j < medicos[i].getnCitas(); j++) {
                        if (citas[j].getPaciente().getSip() == sip) {
                            citasSip[cont] = citas[j];
                            cont++;
                        }
                    }
                }
            }
        }
        return citasSip;
    }

    public Cita[] buscarCitasPorMedico(int nColegiado) {
        Cita[] citas =  null;
        for(int i = 0; i < nMedicos; i++) {
            if (medicos[i].getNumColegiado() == nColegiado) {
                Cita[] citasMedico = medicos[i].getCitas();
                citas = new Cita[medicos[i].getnCitas()];
                for(int j = 0; j < citas.length; j++) {
                    citas[j] = citasMedico[j];
                }
                return citas;
            }
        }
        return null;
    }

    public int nuevoPaciente(int sip, String nombre, String apellido1, String apellido2, Paciente.Sexo sexo, int edad) {
        this.pacientes[nPacientes] = new Paciente(sip, nombre, apellido1, apellido2, sexo, edad);
        //Utilizamos post incremento para que el return devuelva la posición donde lo ha insertado
        return nPacientes++;
    }
}
