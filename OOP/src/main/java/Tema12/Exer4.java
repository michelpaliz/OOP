package Tema12;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exer4 {
    public Exer4() {
        String path = System.getProperty("user.dir");
        File file = new File(path);
        System.out.println("Name");
        System.out.println(file.getName());
        System.out.println("Absolute path");
        System.out.println(file.getAbsolutePath());
        System.out.println("Is ocult the file");
        System.out.println("Can it be read");
        System.out.println(file.canRead());
        System.out.println("Can it be written");
        System.out.println(file.canWrite());
        System.out.println("Get the last modification of the file");
        SimpleDateFormat df1 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
        SimpleDateFormat df2 = new SimpleDateFormat("EEE, MMM d, ''yy");
        SimpleDateFormat df3 = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        long lastModified = file.lastModified();
        Date d = new Date(lastModified * 1000);
        System.out.println("Date formated " + df2.format(d));
        System.out.println("Size of the file");
        System.out.println("Bytes " + file.length());
        double kb = file.length() / 1000;
        System.out.printf("%.2f KB ", kb);
        double mb = file.length() / 1000000;
        System.out.printf(" %.2f MB  ", mb);

        try {
            System.out.println("USING PATH");
            Path pathName = Paths.get(path);
            BasicFileAttributes attr = Files.readAttributes(pathName, BasicFileAttributes.class);

            System.out.println("creationTime: " + attr.creationTime());
            System.out.println("lastAccessTime: " + attr.lastAccessTime());
            System.out.println("lastModifiedTime: " + attr.lastModifiedTime());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
