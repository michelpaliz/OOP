package Testing.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;

import Util.Control;
import Util.Lib;

public class MyDate {

    public MyDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTimeObj = LocalDateTime.now();
        LocalDate localDateObj = LocalDate.now();

        GregorianCalendar gc = GregorianCalendar.from(localDateObj.atStartOfDay(ZoneId.systemDefault()));

        System.out.println("The code below is a localDateTime Obj");
        System.out.println(dtf.format(localDateTimeObj));
        // System.out.println("The code below is a localDate obj");
        // System.out.println(dtf.format(localDateObj));
        System.out.println("************GREGORIAN CALENDAR**********");
        // System.out.println("The code below is a gregorian calendar");
        // System.out.println(dtf.format((TemporalAccessor) gc));
        System.out.println("This is a random Gregorian calendar");
        System.out.println(Control.birthFormat(rndBirth()));
        System.out.println(rndBirth());
        // System.out.println(rndBirth());
        // System.out.println(Control.birthFormat(rndBirth()));

    }

    // public GregorianCalendar rndBirth() {
    // GregorianCalendar gc = new GregorianCalendar();
    // int year = randBetween(1900, 2000);
    // gc.set(gc.YEAR, year);

    // int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

    // gc.set(gc.DAY_OF_YEAR, dayOfYear);

    // // System.out.println(gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" +
    // // gc.get(gc.DAY_OF_MONTH));

    // return gc;
    // }

    public static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public GregorianCalendar rndBirth() {
        int minDay = (int) LocalDate.of(2000, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
        long randomDay = minDay + Lib.r.nextInt(maxDay - minDay);
        LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
        System.out.println("This is randomDay");
        System.out.println(randomDay);
        GregorianCalendar gc = GregorianCalendar.from(randomBirthDate.atStartOfDay(ZoneId.systemDefault()));
        return gc;

    }

}
