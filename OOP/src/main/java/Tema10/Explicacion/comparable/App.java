package Tema10.Explicacion.comparable;

import java.util.ArrayList;
import java.util.Random;

public class App {

    public App() {

        Random r = new Random();

        ArrayList<Empleado> empleados = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            empleados.add(new Empleado(i + "A", "Empleado" + i, r.nextInt(100)));
        }

      }
        }
    

    }

}
