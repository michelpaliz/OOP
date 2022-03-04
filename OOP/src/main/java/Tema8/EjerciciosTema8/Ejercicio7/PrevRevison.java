package Tema8.EjerciciosTema8.Ejercicio7;

public class PrevRevison {

    // Atributos
    private final double temperatura;
    private final int pulsacion;
    private final int tensionSis;
    private final int tensionDias;
    // public PrevRevison prevRevison;

    public PrevRevison(double temperatura, int pulsacion, int tensionSis, int tensionDias) {
        this.temperatura = temperatura;
        this.pulsacion = pulsacion;
        this.tensionSis = tensionSis;
        this.tensionDias = tensionDias;
    }



    public double getTemperatura() {
        return temperatura;
    }

    public int getPulsacion() {
        return pulsacion;
    }

    public int getTensionSis() {
        return tensionSis;
    }

    public int getTensionDias() {
        return tensionDias;
    }

    @Override
    public String toString() {
        return "PrevRevison [pulsacion=" + pulsacion + ", temperatura=" + temperatura + ", tensionDias=" + tensionDias
                + ", tensionSis=" + tensionSis + "]";
    }

}
