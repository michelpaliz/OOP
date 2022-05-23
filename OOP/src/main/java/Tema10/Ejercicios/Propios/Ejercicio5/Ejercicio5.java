package Tema10.Ejercicios.Propios.Ejercicio5;

import Lib.Util;

public class Ejercicio5 {


    public void menu(){

    }

    private void operationIntroducirPal(){
        Traducir trac = new Traducir();
        int times= 1;
        times = Util.readInt("Cue");
        for(int i = 0; i < times; i++) {
            String palabraIng = Util.askString();
            String palabraVal = Util.askString();
            trac.introducirPareja(palabraIng,palabraVal);
        }
    }

    
}
