package Testing.date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.github.javafaker.Faker;

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
        // System.out.println(Control.birthFormat(rndBirth()));
        System.out.println(Control.birthFormat(randGreg()));
        System.out.println("This is faker date");
        generateFaker();
        // System.out.println(rndBirth());
    }

    public GregorianCalendar rndBirth() {
        GregorianCalendar gc = new GregorianCalendar();
        // Creating an object of Calendar Class
        Calendar cal = Calendar.getInstance();
        int year = randBetween(1900, cal.getWeekYear());

        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        gc.set(gc.DAY_OF_MONTH, dayOfYear);
        gc.set(gc.MONTH, dayOfYear);

        // System.out.println(gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" +
        // gc.get(gc.DAY_OF_MONTH));

        return gc;
    }

    public static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    // public GregorianCalendar rndBirth() {
    // int minDay = (int) LocalDate.of(2000, 1, 1).toEpochDay();
    // int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
    // System.out.println("This is minday");
    // System.out.println(minDay);
    // long randomDate = minDay + Lib.r.nextInt(maxDay - minDay);
    // LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDate);
    // System.out.println("This is randomDate");
    // System.out.println(randomDate);
    // GregorianCalendar gc =
    // GregorianCalendar.from(randomBirthDate.atStartOfDay(ZoneId.systemDefault()));
    // return gc;
    // }

    public GregorianCalendar randGreg() {
        SimpleDateFormat dfDateTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault());
        int year = randBetween(1900, 2013);// Here you can set Range of years you need
        int month = randBetween(0, 11);
        int hour = randBetween(9, 22); // Hours will be displayed in between 9 to 22
        int min = randBetween(0, 59);
        int sec = randBetween(0, 59);

        GregorianCalendar gc = new GregorianCalendar(year, month, 1);
        int day = randBetween(1, gc.getActualMaximum(gc.DAY_OF_MONTH));

        gc.set(year, month, day, hour, min, sec);
        return gc;
    }

    public void generateFaker() {
        Faker usFaker = new Faker(new Locale("en-US"));
        System.out.println(String.format("City in US: %s", usFaker));
    }
}
