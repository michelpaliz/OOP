package Tema11.Propios.ejercicio06.models;

import java.util.GregorianCalendar;
import java.util.TimeZone;

import Util.Control;

public class partner {
    private String ID;
    private String name;
    private GregorianCalendar db;
    private String city;

    public partner(){
        TimeZone tz = null;
        this.ID = "53944920F";
        this.name = "Jhoan";
        this.db = Control.birthFormat();
        
    } 


}
