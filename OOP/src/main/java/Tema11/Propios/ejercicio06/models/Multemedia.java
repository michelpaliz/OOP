package Tema11.Propios.ejercicio06.models;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Multemedia {
    // to store info of our objects
    private String title;
    private String author;
    private Format format;
    private GregorianCalendar launchDate;

    public Multemedia() {
        this.title = "My book";
        this.author = "MIchael";
        this.format = Format.BLUE_RAY;
        this.launchDate = new GregorianCalendar(TimeZone.getTimeZone("GMT+5:30"));
    }

    public Multemedia(String title, String name, Format format, GregorianCalendar launchDate) {
        this.title = title;
        this.author = name;
        this.format = format;
        this.launchDate = launchDate;
    }

    @Override
    public String toString() {
        return "Multemedia [format=" + format + ", launchDate=" + launchDate + ", name=" + author + ", title=" + title
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((format == null) ? 0 : format.hashCode());
        result = prime * result + ((launchDate == null) ? 0 : launchDate.hashCode());
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        // returns a true if the title and the actor are the same as the paramether and
        // false otherwise.
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Multemedia other = (Multemedia) obj;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        // be careful bcs if our main obj is null and the paramether is null as well it
        // will lauchn a true value
        return true;
    }

}
