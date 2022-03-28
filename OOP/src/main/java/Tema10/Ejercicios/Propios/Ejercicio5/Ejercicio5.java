package Tema10.Ejercicios.Propios.Ejercicio5;

import Util.Lib;

public class Ejercicio5 {


    public void menu(){

    }

    private void operationIntroducirPal(){
        Traducir trac = new Traducir();
        int times= 1;
        times = Lib.readInt("Cue");
        for(int i = 0; i < times; i++) {
            String palabraIng = Lib.askString();
            String palabraVal = Lib.askString();
            trac.introducirPareja(palabraIng,palabraVal);
        }
    }

    
}
