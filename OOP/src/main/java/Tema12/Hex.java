package Tema12;

public class Hex {

    public Hex()  {

        try {
            
        } catch (Exception e) {
            //TODO: handle exception
        }
        byte[] array = { 40, 5, 7, 6 };
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%x ", array[i]);
            System.out.printf("%c ", array[i]);
        }
        System.out.println();
    }

}