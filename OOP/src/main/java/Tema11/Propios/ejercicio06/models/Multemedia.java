package Tema11.Propios.ejercicio06.models;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Multemedia {
    // to store info of our objects
    private String title;
    private String name;
    private Format format;
    private GregorianCalendar launchDate;

    public Multemedia() {
        this.title = "My book";
        this.name = "MIchael";
        this.format = Format.BLUE_RAY;
        this.launchDate = new GregorianCalendar(TimeZone.getTimeZone("GMT+5:30"));
    }

    public Multemedia(String title, String name, Format format, GregorianCalendar launchDate) {
        this.title = title;
        this.name = name;
        this.format = format;
        this.launchDate = launchDate;
    }

}
