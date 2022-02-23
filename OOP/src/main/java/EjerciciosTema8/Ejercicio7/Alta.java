package EjerciciosTema8.Ejercicio7;

import java.util.GregorianCalendar;

public class Alta {

    // Atributo
    private GregorianCalendar fechaAlta;
    private String motivoAlta;

    public Alta(GregorianCalendar fechaAlta, String motivoAlta) {
        this.fechaAlta = fechaAlta;
        this.motivoAlta = motivoAlta;
    }

    @Override
    public String toString() {
        return "Alta [fechaAlta=" + fechaAlta + ", motivoAlta=" + motivoAlta + "]";
    }

}
