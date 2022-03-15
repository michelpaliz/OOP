package com.germangascon.tema08.ejercicio07;

import com.germangascon.tema08.utils.Lib;
import com.github.javafaker.Faker;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class CentroSalud {
    private final Paciente[] pacientes;
    private final AtencionMedica[] historial;

    private int nPacientes;
    private int nRegistros;
    private int lastSIP = 10103001;
    private final String[] arraySintomatologia = {"Dolor abdominal", "Mareo generalizado", "Dolor fuerte en el pecho", "Dolor en el brazo", "Dolor en la pierna", "Gripe", "Resfriado común", "Escalofríos", "Migraña intensa", "Fuerte contusión"};


    public CentroSalud(int maxPacientes, int maxHistorial) {
        this.pacientes = new Paciente[maxPacientes];
        this.historial = new AtencionMedica[maxHistorial];
        this.nPacientes = 0;
        this.nRegistros = 0;
    }

    public void generarDatosAleatorios(int nPacientes, int nRegistrosHistorial) {
        generarPacientesAleatorios(nPacientes);
        generarRegistrosHistorialAleatorios(nRegistrosHistorial);
        ordenar(historial);
    }

    private void generarPacientesAleatorios(int nPacientes) {
        Faker faker = new Faker(new Locale("es"));
        int sip;
        String nombre;
        String apellido1;
        String apellido2;
        Paciente.Sexo sexo;
        int edad;
        for(int i = 0; i < nPacientes; i++) {
            sip = ++lastSIP;
            nombre = faker.name().firstName();
            apellido1 = faker.name().lastName();
            apellido2 = faker.name().lastName();
            sexo = Lib.random(0, 1) == 0 ? Paciente.Sexo.M : Paciente.Sexo.V;
            edad = Lib.random(1, 90);
            pacientes[i] = new Paciente(sip, nombre, apellido1, apellido2, sexo, edad);
            this.nPacientes++;
        }
    }

    private void generarRegistrosHistorialAleatorios(int nRegistrosHistorial) {
        int restantes = nRegistrosHistorial;
        int anyoActual = new GregorianCalendar().get(Calendar.YEAR);
        //OJO Enero es 0
        int mesActual = new GregorianCalendar().get(Calendar.MONTH);
        int diaActual = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
        while(restantes > 0) {
            int i = 0;
            while(i < nPacientes && restantes > 0) {
                int anyo = anyoActual;
                int mes = mesActual;
                int dia = Lib.random(1, diaActual);
                int hora = Lib.random(0,23);
                int minutos = Lib.random(0,59);
                GregorianCalendar fechaEntrada = new GregorianCalendar(anyo, mes, dia, hora, minutos);
                String sintomatologia = arraySintomatologia[Lib.random(0,arraySintomatologia.length-1)];
                float temperatura = Lib.random(36.5f, 41);
                float ppm = Lib.random(50, 120);
                float tenSis = Lib.random(105, 180);
                float tenDias = Lib.random(45, 105);
                //Si el paciente no ha entrado hoy suponemos que se le ha dado el alta
                if(dia != diaActual) {
                    GregorianCalendar fechaAlta = new GregorianCalendar();
                    fechaAlta.setTime(fechaEntrada.getTime());
                    fechaAlta.add(Calendar.HOUR_OF_DAY, Lib.random(1,12));
                    fechaAlta.add(Calendar.MINUTE, Lib.random(2,59));
                    int mAlta = Lib.random(1,100);
                    AtencionMedica.MotivoAlta motivoAlta;
                    if(mAlta <= 75) {
                        motivoAlta = AtencionMedica.MotivoAlta.MEJORA;
                    } else if(mAlta <=99){
                        motivoAlta = AtencionMedica.MotivoAlta.DERIVACION_HOSPITAL;
                    } else {
                        motivoAlta = AtencionMedica.MotivoAlta.DEFUNCION;
                    }
                    historial[nRegistros] = new AtencionMedica(pacientes[i], sintomatologia, fechaEntrada, temperatura, ppm, tenSis, tenDias, fechaAlta, motivoAlta);
                } else { //El paciente continua en el centro de salud
                    historial[nRegistros] = new AtencionMedica(pacientes[i], sintomatologia);
                    boolean atendido = Lib.random(0,1) == 0 ? false : true;
                    if(atendido) {
                        historial[nRegistros].atender(temperatura, ppm, tenSis, tenDias);
                    }
                }
                i++;
                nRegistros++;
                restantes--;
            }
        }
    }

    public Paciente[] getPacientes() {
        return this.pacientes;
    }

    public AtencionMedica[] getHistorial() {
        return this.historial;
    }

    public AtencionMedica[] buscarHistoricoPorSip(int sip) {
        boolean fin = false;
        int i = 0;
        int registrosPaciente = 0;
        AtencionMedica[] historicoPaciente = null;
        while(i < historial.length && !fin) {
            if(historial[i]!= null) {
                if (historial[i].getPaciente().getSip() == sip) {
                    registrosPaciente++;
                }
                i++;
            } else {
                fin = true;
            }
        }
        if(registrosPaciente > 0) {
            historicoPaciente = new AtencionMedica[registrosPaciente];
            i = 0;
            int cont = 0;
            fin = false;
            /** Una vez sabemos el número de registros del paciente los asignamos al vector **/
            while(i < historial.length && !fin) {
                if(historial[i]!= null) {
                    if (historial[i].getPaciente().getSip() == sip) {
                        historicoPaciente[cont] = historial[i];
                        cont++;
                    }
                    i++;
                } else {
                    fin = true;
                }
            }
        }
        return historicoPaciente;
    }

    public int buscarPacientePorSip(int sip) {
        int i = 0;
        boolean fin = false;
        while(i < pacientes.length && !fin) {
            if(pacientes[i]!= null) {
                if (pacientes[i].getSip() == sip) {
                    return i;
                }
                i++;
            } else {
                fin = true;
            }
        }
        return -1;
    }

    public AtencionMedica[] buscarHistoricoPorFechas(GregorianCalendar fechaInicio, GregorianCalendar fechaFin) {
        boolean fin = false;
        int i = 0;
        int registrosFechas = 0;
        AtencionMedica[] historicoFechas = null;
        if(fechaFin == null) {
            fechaFin = new GregorianCalendar();
        }
        while(i < historial.length && !fin) {
            if(historial[i]!= null) {
                if (historial[i].getFechaEntrada().getTimeInMillis() >= fechaInicio.getTimeInMillis() &&
                        historial[i].getFechaEntrada().getTimeInMillis() <= fechaFin.getTimeInMillis()) {
                    registrosFechas++;
                }
                i++;
            } else {
                fin = true;
            }
        }
        if(registrosFechas > 0) {
            historicoFechas = new AtencionMedica[registrosFechas];
            i = 0;
            int cont = 0;
            fin = false;
            /** Una vez sabemos el número de registros del paciente los asignamos al vector **/
            while(i < historial.length && !fin) {
                if(historial[i]!= null) {
                    if (historial[i].getFechaEntrada().getTimeInMillis() >= fechaInicio.getTimeInMillis() &&
                            historial[i].getFechaEntrada().getTimeInMillis() <= fechaFin.getTimeInMillis()) {
                        historicoFechas[cont] = historial[i];
                        cont++;
                    }
                    i++;
                } else {
                    fin = true;
                }
            }
        }
        return historicoFechas;
    }

    public void ordenar(AtencionMedica[] vector) {
        boolean hayCambios = true;
        while(hayCambios) {
            hayCambios = false;
            for(int i = 0; i < vector.length - 1; i++) {
                //Si el elemento actual es mayor que el elemento siguiente los intercambiamos
                if(vector[i] != null && vector[i+1] != null) {
                    if(vector[i].getFechaEntrada().getTimeInMillis() > vector[i+1].getFechaEntrada().getTimeInMillis()) {
                        intercambio(vector, i, i + 1);
                        hayCambios = true;
                    }
                }
            }
        }
    }

    public void intercambio(AtencionMedica[] vector, int i, int j) {
        AtencionMedica aux = vector[i];
        vector[i] = vector[j];
        vector[j] = aux;
    }

    public int nuevoPaciente(int sip, String nombre, String apellido1, String apellido2, Paciente.Sexo sexo, int edad) {
        this.pacientes[nPacientes] = new Paciente(sip, nombre, apellido1, apellido2, sexo, edad);
        //Utilizamos post incremento para que el return devuelva la posición donde lo ha insertado
        return nPacientes++;
    }

    public int registrarPaciente(Paciente paciente, String sintomatologia) {
        historial[nRegistros] = new AtencionMedica(paciente, sintomatologia);
        //Utilizamos post incremento para que el return devuelva la posición donde lo ha insertado
        return nRegistros++;
    }

    public AtencionMedica obtenerRegistroAtencionPaciente(int sip) {
        AtencionMedica atencionMedica = null;
        int i = 0;
        boolean fin = false;
        while(i < historial.length && !fin) {
            if(historial[i] != null) {
                if (historial[i].getPaciente().getSip() == sip && historial[i].getFechaAlta() == null) {
                    atencionMedica = historial[i];
                }
            } else {
                fin = true;
            }
            i++;
        }
        return atencionMedica;
    }

    public boolean atenderPaciente(int sip, float temperatura, float ppm, float tenSis, float tenDias) {
        AtencionMedica atencionMedica = obtenerRegistroAtencionPaciente(sip);
        if(atencionMedica != null) {
            return atencionMedica.atender(temperatura, ppm, tenSis, tenDias);
        }
        return false;
    }

    public float mediaTemperatura() {
        int i = 0;
        boolean fin = false;
        float temperatura = 0;
        while(i < historial.length && !fin) {
            if(historial[i] != null) {
                temperatura += historial[i].getPreRev()[0];
                i++;
            } else {
                fin = true;
            }
        }
        return temperatura/i;
    }

    public float mediaPpm() {
        int i = 0;
        boolean fin = false;
        float ppm = 0;
        while(i < historial.length && !fin) {
            if(historial[i] != null) {
                ppm += historial[i].getPreRev()[1];
                i++;
            } else {
                fin = true;
            }
        }
        return ppm/i;
    }

    public float mediaTenSis() {
        int i = 0;
        boolean fin = false;
        float tenSis = 0;
        while(i < historial.length && !fin) {
            if(historial[i] != null) {
                tenSis += historial[i].getPreRev()[2];
                i++;
            } else {
                fin = true;
            }
        }
        return tenSis/i;
    }

    public float mediaTenDias() {
        int i = 0;
        boolean fin = false;
        float tenDias = 0;
        while(i < historial.length && !fin) {
            if(historial[i] != null) {
                tenDias += historial[i].getPreRev()[3];
                i++;
            } else {
                fin = true;
            }
        }
        return tenDias/i;
    }

    public float[] mediaPreRev() {
        int i = 0;
        boolean fin = false;

        float[] preRev = new float[4];
        while(i < historial.length && !fin) {
            if(historial[i] != null) {
                for(int j = 0; j < preRev.length; j++) {
                    preRev[j] += historial[i].getPreRev()[j];
                }
                i++;
            } else {
                fin = true;
            }
        }
        for(int j = 0; j < preRev.length; j++) {
            preRev[j] /= i;
        }
        return preRev;
    }

    public float mediaEdadPacientes() {
        int i = 0;
        boolean fin = false;
        float edad = 0;
        while(i < pacientes.length && !fin) {
            if(pacientes[i] != null) {
                edad += pacientes[i].getEdad();
                i++;
            } else {
                fin = true;
            }
        }
        return edad/i;
    }

    public float porcentajeMujeres() {
        int i = 0;
        boolean fin = false;
        float nMujeres = 0;
        while(i < pacientes.length && !fin) {
            if(pacientes[i] != null) {
               if(pacientes[i].getSexo() == Paciente.Sexo.M) {
                   nMujeres++;
               }
               i++;
            } else {
                fin = true;
            }
        }
        return (nMujeres/nPacientes)*100;
    }

    public float porcentajeHombres() {
        int i = 0;
        boolean fin = false;
        float nHombres = 0;
        while(i < pacientes.length && !fin) {
            if(pacientes[i] != null) {
                if(pacientes[i].getSexo() == Paciente.Sexo.V) {
                    nHombres++;
                }
                i++;
            } else {
                fin = true;
            }
        }
        return (nHombres/nPacientes)*100;
    }
}
